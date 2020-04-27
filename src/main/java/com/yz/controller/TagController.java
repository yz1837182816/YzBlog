package com.yz.controller;

import com.yz.service.TagService;
import com.yz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;
    private Long TempId = 0L;

    @PostMapping("/saveTag")
    public String save(String typename,Model model){
        model.addAttribute("flag",tagService.saveTag(typename));
        return "redirect:toCtrlTags";
    }
    @GetMapping({"/toCtrlTags","/{id}/toCtrlTags"})
    public String lode(Model model){
        model.addAttribute("page",tagService.getList());
        return "admin/tags";
    }
    @GetMapping("/{id}/updateTag")
    public String update(@PathVariable Long id, Model model){
        TempId = id;
        return "admin/tagUpdate";
    }
    @PostMapping("/updateTag")
    public String updateEdit(String typename,Model model){
        model.addAttribute("flag",tagService.updateTag(TempId,typename));
        return "redirect:toCtrlTags";
    }
    @GetMapping("/{id}/deleteTag")
    public String delete(@PathVariable Long id,Model model){
        model.addAttribute("flag",tagService.deleteTag(id));
        return "redirect:toCtrlTags";
    }
    @GetMapping("/toCtrlTagInput")
    public String toTagInput() {
        return "admin/tagInput";
    }
}
