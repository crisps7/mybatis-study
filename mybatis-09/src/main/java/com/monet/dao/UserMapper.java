package com.monet.dao;

import com.monet.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //根据ID查询用户
    User queryUserById(@Param("id") int id);

    int updateUser(User user);
}
