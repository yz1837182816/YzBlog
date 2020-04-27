package com.yz.mapper;

import com.yz.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    void saveComment(String nickname, String email, String content, String random,Timestamp time, BigInteger blogId);
    List<Comment> getListById(BigInteger bId);
}
