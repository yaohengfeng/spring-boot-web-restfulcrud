package com.yhf.springboot.service.impl;

import com.yhf.springboot.dao.IUserDao;
import com.yhf.springboot.domain.User;
import com.yhf.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class userServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<String,String > string;

    @Override
    public List<User> selectAll() {
        return userDao.listUser();
    }

    @Override
    public User selectUserByNameAndPassword(String name, String password) {
        return userDao.loginUser(name,password);
    }


    @Override
    public String loginValdate(String uname) {
        String key=User.getLoginCountFailKey(uname);
        int num=5;//登陆错误的次数
        if (!redisTemplate.hasKey(key)){//如果不存在
            redisTemplate.opsForValue().set(key,"1");
            redisTemplate.expire(key,1,TimeUnit.MINUTES);
            return "登陆失败，当前还能输入"+(num-1)+"次";
        }else {
            long  loginFailCount=Long.parseLong(redisTemplate.opsForValue().get(key)) ;
            if (loginFailCount<(num-1)){
                //对指定数值加1
                redisTemplate.opsForValue().increment(key,1);
                Long seconds = redisTemplate.getExpire(key, TimeUnit.SECONDS);
                return "登陆失败，在"+seconds+"秒内还能输入"+(num-loginFailCount-1)+"次";
            }else {//超过登陆次数
                redisTemplate.opsForValue().set(User.getLoginTimeLockKey(uname),"1");
                redisTemplate.expire(User.getLoginTimeLockKey(uname),1,TimeUnit.HOURS);
                return "因登陆失败次数超过"+num+"次,已限定其登陆1小时";
            }
        }
    }

    /**
     * 判断是否被限制登陆
     * @param uname
     * @return
     */
    @Override
    public Map<String,Object> loginUserLock(String uname) {
        String key = User.getLoginTimeLockKey(uname);
        Map<String,Object> map=new HashMap<>();

        if (redisTemplate.hasKey(key)){
            Long lockTime = redisTemplate.getExpire(key, TimeUnit.MINUTES);
            //如果存在
            map.put("flag",true);
            map.put("lockTime",lockTime);
        }else {
            map.put("flag",false);
        }
        return map;
    }
}
