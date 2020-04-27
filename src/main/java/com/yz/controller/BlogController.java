package com.yz.controller;

import com.yz.pojo.Blog;
import com.yz.service.BlogService;
import com.yz.service.TagService;
import com.yz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping({"/toCtrl","/{id}/toCtrl"})
    public String lode(Model model){
        model.addAttribute("types",typeService.getList());
        return "admin/ctrl";
    }

    @GetMapping("/{id}/updateBlog")
    public String updateBlog(@PathVariable Long id,Blog blog,Model model){
        model.addAttribute("types",typeService.getList());
        model.addAttribute("tags",tagService.getList());
        model.addAttribute("blog",blogService.getBlogById(id));
        blogService.saveBlog(blog,id);
        return "admin/input";
    }

    @PostMapping("/queryBlog")
    public String queryBlog(Model model,String title,Long typeId,boolean recommend){
        model.addAttribute("page",blogService.queryBlog(typeId,title,recommend));
        return "admin/ctrl";
    }

    @GetMapping("/{id}/deleteBlog")
    public String deleteBlog(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "redirect:toCtrl";
    }

    @GetMapping("/toInput")
    public String toInput(Model model) {
        model.addAttribute("types",typeService.getList());
        model.addAttribute("tags",tagService.getList());
        model.addAttribute("blog",new Blog());
        return "admin/input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog){
        blogService.saveBlog(blog,null);
        return "redirect:toCtrl";
    }


}
