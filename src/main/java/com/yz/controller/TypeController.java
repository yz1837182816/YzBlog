package com.yz.controller;

import com.yz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;
    private Long TempId = 0L;

    @PostMapping("/save")
    public String save(String typename,Model model){
        model.addAttribute("flag",typeService.saveType(typename));
        return "redirect:toCtrlTypes";
    }
    @GetMapping({"/toCtrlTypes","/{id}/toCtrlTypes"})
    public String lode(Model model){
        model.addAttribute("page",typeService.getList());
        return "admin/types";
    }
    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id, Model model){
        TempId = id;
        return "admin/typeUpdate";
    }
    @PostMapping("/update")
    public String updateEdit(String typename,Model model){
        model.addAttribute("flag",typeService.updateType(TempId,typename));
        return "redirect:toCtrlTypes";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id,Model model){
        model.addAttribute("flag",typeService.deleteType(id));
        return "redirect:toCtrlTypes";
    }
    @GetMapping("/toTypeInput")
    public String toTypeInput() {
        return "admin/typeInput";
    }
}
