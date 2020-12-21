package com.liuhjhj.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ExitController {

    @GetMapping("/exit")
    public String toLoginPage(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/index";
    }
}
