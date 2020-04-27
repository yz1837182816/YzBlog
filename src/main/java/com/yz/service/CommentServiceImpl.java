package com.yz.service;

import com.yz.mapper.CommentMapper;
import com.yz.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class CommentServiceImpl implements CommentService {
@Autowired
private CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByBlogId(Long blogid) {
        return null;
    }

    @Override
    public void saveComment(Comment comment) {
        commentMapper.saveComment(comment.getNickname(),comment.getEmail()==null?"null":comment.getEmail(),
                comment.getContent(),String.valueOf(new Random().nextInt(20)),new Timestamp(System.currentTimeMillis()),new BigInteger(String.valueOf(comment.getBlogId())));
    }

    @Override
    public List<Comment> getListById(Long bId){
        return commentMapper.getListById(new BigInteger(String.valueOf(bId)));
    }
}
