package com.yz.controller;

import com.yz.pojo.Comment;
import com.yz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.getListById(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/toComment")
    public String post(Comment comment){
        if (!comment.getContent().equals("null")) {
            commentService.saveComment(comment);
        }
        return "redirect:/comments/" + comment.getBlogId();
    }

}
