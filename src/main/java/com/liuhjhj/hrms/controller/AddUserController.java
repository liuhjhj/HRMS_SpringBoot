package com.liuhjhj.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddUserController {

    @GetMapping("/add-new-user")
    public String toAddNewUserPage(){
        return "";
    }
}
