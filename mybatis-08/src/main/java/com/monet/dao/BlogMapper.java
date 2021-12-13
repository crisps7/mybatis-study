package com.monet.dao;

import com.monet.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询blog
    List<Blog> queryBlogIf(Map map);

    //更新博客
    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);


    //查询第一二三号记录的博客
    List<Blog> queryBlogForeach(Map map);


}
