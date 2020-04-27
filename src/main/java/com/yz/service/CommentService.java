package com.yz.service;

import com.yz.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
    void saveComment(Comment comment);
    List<Comment> getListById(Long BId);
}
