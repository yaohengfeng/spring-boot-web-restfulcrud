package com.yhf.springboot.test;

import com.yhf.springboot.dao.IUserDao;
import com.yhf.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private IUserDao IUserDao;

    @Test
    public void listUserTest(){
        List<User> users = IUserDao.listUser();
        /*for (User user: users) {
            System.out.println(user);
        }*/
        System.out.println(users);

        User user = IUserDao.loginUser("yhf", "1234567");

        System.out.println(user);
       /* User user=new User();
        user.setuName("张三");
        user.setPassword("123456");
        userDao.saveUser(user);*/
    }
}
