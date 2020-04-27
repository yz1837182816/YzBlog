package com.yz.controller;

import com.yz.service.BlogService;
import com.yz.service.CommentService;
import com.yz.service.TagService;
import com.yz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CommentService commentService;

    @GetMapping({"/toIndex","/"})
    public String toIndex(Model model) {
        model.addAttribute("page",blogService.getIndexBlogList());
        model.addAttribute("types",typeService.getList());
        model.addAttribute("tags",tagService.getList());
        model.addAttribute("titles",blogService.getTitles());
        return "index";
    }

    @PostMapping("/toSearch")
    public String toSearch(@RequestParam String query,Model model){
        model.addAttribute("page",blogService.getSearch(query));
        return "search";
    }

    @GetMapping("/toBlog/{id}")
    public String toBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog",blogService.getBlogById(id));
        return "blog";
    }
}
