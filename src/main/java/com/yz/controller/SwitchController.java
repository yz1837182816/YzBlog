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

@Controller
public class SwitchController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;

    @GetMapping("/toAbout")
    public String toAbout() {
        return "about";
    }

    @GetMapping("/toTags")
    public String toTags(Model model) {
        model.addAttribute("tags",tagService.getList());
        return "tags";
    }

    @GetMapping("/tagQuery/{id}")
    public String tagQuery(@PathVariable int id,Model model){
        model.addAttribute("tags",tagService.getList());
        model.addAttribute("page",blogService.getBlogsByTag(id));
        model.addAttribute("activeId",id);
        return "tags";
    }

    @GetMapping("/toArchives")
    public String toArchives(Model model) {
        model.addAttribute("blogs20",blogService.getBlogsByDate(2020));
        model.addAttribute("blogs19",blogService.getBlogsByDate(2019));
        return "archives";
    }

    @GetMapping("/typeQuery/{id}")
    public String typeQuery(@PathVariable int id,Model model){
        model.addAttribute("types",typeService.getList());
        model.addAttribute("page",blogService.getBlogsByType(id));
        model.addAttribute("activeId",id);
        return "types";
    }

}
