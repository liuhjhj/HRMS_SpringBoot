package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.entity.Staff;
import com.liuhjhj.hrms.entity.User;
import com.liuhjhj.hrms.service.implement.StaffServiceImplement;
import com.liuhjhj.hrms.service.implement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/add_new_user")
public class AddUserController {

    private StaffServiceImplement staffServiceImplement;

    private UserServiceImplement userServiceImplement;

    @Autowired
    public void setStaffServiceImplement(StaffServiceImplement staffServiceImplement) {
        this.staffServiceImplement = staffServiceImplement;
    }

    @Autowired
    public void setUserServiceImplement(UserServiceImplement userServiceImplement) {
        this.userServiceImplement = userServiceImplement;
    }

    @GetMapping()
    public String toAddNewUserPage(Model model) {
        List<Staff> staffs = staffServiceImplement.getStaffsWithoutUser();
        model.addAttribute("staffs", staffs);
        return "add_new_user";
    }

    @PostMapping()
    public String addUser(User user) {
        userServiceImplement.addUser(user);
        System.out.println("Add User:" + user);
        return "add_new_user";
    }
}
