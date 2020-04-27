package com.yz.mapper;


import com.yz.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    void addViews(BigInteger id);
    List<Blog> queryBlog(Long typeId, String title, int recommend);
    void saveBlog(String title, String content, String firstPicture, String flag, int appreciation, int shareStatement,
                  int commentabled, int published, int recommend, Timestamp createTime, Timestamp updateTime, int typeId, String description, String tagIds);
    void deleteBlog(BigInteger id);
    Blog getBlogById(BigInteger id);
    void updateBlog(BigInteger id, String title, String content, String firstPicture, String flag, int appreciation
    , int commentabled, int published, int recommend, Timestamp updateTime, int typeId, String description, String tagIds);
    List<Blog> getIndexBlogList();
    List<Blog> getBlogsByKeyValue(String keyWord);
    List<Blog> getBlogsByType(int id);
    List<Blog> getBlogsByTag(String id);
}
