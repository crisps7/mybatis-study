package com.monet.dao;

import com.monet.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据ID查询用户
    User getUserById(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

}
