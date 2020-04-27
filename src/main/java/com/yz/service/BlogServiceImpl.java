package com.yz.service;

import com.yz.mapper.BlogMapper;
import com.yz.pojo.Blog;
import com.yz.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> queryBlog(Long typeId, String title, boolean recommend) {
        return blogMapper.queryBlog(typeId,title,recommend?1:0);
    }

    @Override
    public Blog getBlogById(Long id) {
        blogMapper.addViews(new BigInteger(String.valueOf(id)));
        Blog blog = blogMapper.getBlogById(new BigInteger(String.valueOf(id)));
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        return blog;
    }

    @Override
    public void saveBlog(Blog blog,Long id) {
        if (id == null){
            blog.setViews(0);
            blogMapper.saveBlog(blog.getTitle(),blog.getContent(),blog.getFirstPicture(),blog.getFlag()
                    ,blog.isAppreciation()?1:0,blog.isShareStatement()?1:0,blog.isCommentabled()?1:0,blog.isPublished()?1:0,
                    blog.isRecommend()?1:0,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),
                    blog.getTypeId(), blog.getDescription(),blog.getTagIds());
        }else{
            blogMapper.updateBlog(new BigInteger(String.valueOf(id)),blog.getTitle(),blog.getContent(),blog.getFirstPicture(),blog.getFlag()
            ,blog.isAppreciation()?1:0,blog.isCommentabled()?1:0,blog.isPublished()?1:0,blog.isRecommend()?1:0,new Timestamp(System.currentTimeMillis()),
                    blog.getTypeId(), blog.getDescription(),blog.getTagIds());
        }


    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlog(new BigInteger(String.valueOf(id)));
    }

    @Override
    public List<Blog> getIndexBlogList() {
        return blogMapper.getIndexBlogList();
    }

    @Override
    public List<Blog> getTitles() {
        ArrayList<Blog> list = new ArrayList<>();
        blogMapper.getIndexBlogList().forEach((Blog b)->{
            Blog blog = new Blog();
            blog.setId(b.getId());
            blog.setTitle(b.getTitle());
            list.add(blog);
        });
        return list;
    }

    @Override
    public List<Blog> getSearch(String keyword) {
        return blogMapper.getBlogsByKeyValue(keyword);
    }

    @Override
    public List<Blog> getBlogsByType(int id) {
        return blogMapper.getBlogsByType(id);
    }

    @Override
    public List<Blog> getBlogsByTag(int id) {
        return blogMapper.getBlogsByTag(String.valueOf(id));
    }

    @Override
    public List<Blog> getBlogsByDate(int date){
        ArrayList<Blog> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        getIndexBlogList().forEach((Blog b)->{if(String.valueOf(date).equals(format.format(b.getUpdateTime()))){list.add(b);}});
        list.forEach((Blog b)->{System.err.println(b.getUpdateTime());});
        return list;
    }
}
