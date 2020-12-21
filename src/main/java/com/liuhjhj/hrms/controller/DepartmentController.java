package com.liuhjhj.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {

    @GetMapping("/departments")
    public String toListPage(Model model){
        System.out.println("to List Page");
        model.addAttribute("buttonAction","add");
        return "department/list";
    }
}
