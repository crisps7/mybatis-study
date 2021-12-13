package com.monet.dao;

import com.monet.pojo.User;
import com.monet.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

   static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("startIndex",0);
        stringIntegerHashMap.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(stringIntegerHashMap);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
