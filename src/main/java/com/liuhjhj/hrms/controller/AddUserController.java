package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.dao.DepartmentDao;
import com.liuhjhj.hrms.dao.StaffDao;
import com.liuhjhj.hrms.dao.UserDao;
import com.liuhjhj.hrms.entity.Department;
import com.liuhjhj.hrms.entity.Staff;
import com.liuhjhj.hrms.entity.User;
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

    @Autowired
    StaffDao staffDao;

    @Autowired
    UserDao userDao;

    @GetMapping()
    public String toAddNewUserPage(Model model){
        List<Staff> staffs = staffDao.getStaffsWithoutUser();
        model.addAttribute("staffs",staffs);
        return "add_new_user";
    }

    @PostMapping()
    public String addUser(User user){
        userDao.addUser(user);
        System.out.println("Add User:"+user);
        return "redirect:/add_new_user";
    }
}
