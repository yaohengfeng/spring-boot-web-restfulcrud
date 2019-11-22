package com.yhf.springboot.dao;

import com.yhf.springboot.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao {

    List<User> listUser();

    User loginUser(@Param("uName") String uName, @Param("uPassword") String uPassword);

    void saveUser(User user);


}
