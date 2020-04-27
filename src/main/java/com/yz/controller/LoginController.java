package com.yz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author YangZhao
 * @author yangzhaomm@163.com
 * @version 1.0
 */

@Controller
public class LoginController {
    @GetMapping("/toLogin")
    public String login(){ return "login"; }

    @GetMapping("/admin/ctrl")
    public String doLogin(){
        return "admin/hello";
    }

}
