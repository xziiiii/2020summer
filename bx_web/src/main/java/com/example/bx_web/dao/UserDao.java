package com.example.bx_web.dao;

import com.example.bx_web.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User userLogin(String username, String password);
}
