package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @PostMapping("/login")
    public ModelAndView userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {
        //密码错误不能进行重定向，否则错误消息无法显示在页面上
        ModelAndView modelAndView = new ModelAndView("login");
        String inputPassword = userDao.getPassword(username);
        if (!password.equals(inputPassword)) {
            modelAndView.addObject("error", "username_or_password_wrong");
        }else {
            modelAndView.setViewName("redirect:/dashboard");
            session.setAttribute("username", username);
        }
        return modelAndView;
    }
}
