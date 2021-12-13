package com.monet.dao;

import com.monet.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param注解
    @Select("select * from User where id=#{id} ")
    User getUserId(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update User set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from User where id=#{uid}")
    int deleteUser(@Param("uid") int id);
}
