package com.yz.service;

import com.yz.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> queryBlog(Long typeId,String title,boolean recommend);
    void saveBlog(Blog blog,Long id);
    void deleteBlog(Long id);
    Blog getBlogById(Long id);
    List<Blog> getIndexBlogList();
    List<Blog> getTitles();
    List<Blog> getSearch(String keyword);
    List<Blog> getBlogsByType(int id);
    List<Blog> getBlogsByTag(int id);
    List<Blog> getBlogsByDate(int date);
}
