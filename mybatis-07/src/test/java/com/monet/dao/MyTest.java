package com.monet.dao;

import com.monet.pojo.Student;
import com.monet.pojo.Teacher;
import com.monet.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher= mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }


    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher= mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
