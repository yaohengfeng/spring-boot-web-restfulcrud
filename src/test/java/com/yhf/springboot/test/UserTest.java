package com.yhf.springboot.test;

import com.yhf.springboot.dao.ITweetDao;
import com.yhf.springboot.dao.IUserDao;
import com.yhf.springboot.dao.IWTdao;
import com.yhf.springboot.dao.IWXUserDao;
import com.yhf.springboot.domain.Tweet;
import com.yhf.springboot.domain.WXUT;
import com.yhf.springboot.domain.WXUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private IUserDao IUserDao;

    @Autowired
    private IWXUserDao iwxUserDao;

    @Autowired
    private ITweetDao tweetsDao;

    @Autowired
    private IWTdao iwTdao;

    @Test
    public void listUserTest(){
       /* List<WXUser> wxUsers=iwxUserDao.getAll();
        System.out.println(wxUsers);*/
        /*List<Tweet> tweets=tweetsDao.getAllTweets();
        System.out.println(tweets);*/

      /*  List<WXUT> wxuts=iwTdao.getAll();
        System.out.println(wxuts);*/
        /*List<WXUT> wxuts=iwTdao.getAllWT();
        System.out.println(wxuts);*/
/*        WXUT wxut = iwTdao.selectWTByID(1, 1);
        System.out.println(wxut);*/
        /*List<WXUT> wxuts = iwTdao.selectWTByTid(1);
        System.out.println(wxuts);*/
/*        WXUT wxut=new WXUT();
        Date date = new Date();
        System.out.printf(String.valueOf(date));
        wxut.setBrowsingTime(date);
        wxut.setCount(2);
        wxut.setRead(true);
        iwTdao.updateWT(wxut,1,1);*/

        Integer id = iwxUserDao.getId("oYTNys46a-on1ipmlm_pU9OpypTY");
        System.out.println(id);

     /* List<String> list=iwxUserDao.getOpenId();
        System.out.println(list);*/
/*        List<WXUser> list=iwxUserDao.getOpenIdAndWID();
        System.out.println(list);*/
/*        Tweet tweet = tweetsDao.selectTweetsById(1);
        System.out.println(tweet);*/
/*        WXUT wxut=new WXUT();
        wxut.setuId(2);
        wxut.settId(1);
        wxut.setWtTitle("春晓");
        wxut.setSend(false);
        iwTdao.insertWT(wxut);*/

        /*List<User> users = IUserDao.listUser();
        *//*for (User user: users) {
            System.out.println(user);
        }*//*
        System.out.println(users);

        User user = IUserDao.loginUser("yhf", "1234567");

        System.out.println(user);*/
       /* User user=new User();
        user.setuName("张三");
        user.setPassword("123456");
        userDao.saveUser(user);*/
    }
}
