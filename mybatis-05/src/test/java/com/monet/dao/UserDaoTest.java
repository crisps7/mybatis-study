package com.monet.dao;

import com.monet.pojo.User;
import com.monet.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userId = mapper.getUserId(1);
        System.out.println(userId);
        sqlSession.close();
    }


    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(5,"xiaoha","123"));
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"xiaoyi","123"));
        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        sqlSession.close();
    }
}
