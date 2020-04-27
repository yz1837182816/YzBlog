package com.yz.pojo;

import com.yz.mapper.TypeMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;
    private int views;
    private int typeId;
    private String typeName;
    private String description;
    private List<Tag> tags = new ArrayList<>();
    private User user;
    private String tagIds;
    private List<Comment> comments = new ArrayList<>();

    public boolean isAppreciation() {
        return appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public String parseUpdateDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(this.updateTime);
    }
}
