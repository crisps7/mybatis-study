package com.monet.dao;

import com.monet.pojo.User;
import com.monet.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("xiao");
        for (User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void test(){
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try  {
            //执行:getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } finally {
            //关闭
            sqlSession.close();
        }
    }


    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("helloid",1);
        map.put("name","xiaoming");
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlSession.close();
    }


    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res= mapper.addUser(new User(3,"xiaoqi","123"));
        if (res>0){
            System.out.println("提交成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userid",4);
        map.put("userName","xiaoha");
        map.put("password","123");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1,"xiaoming","123"));
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(3);
        sqlSession.commit();
        sqlSession.close();
    }
}
