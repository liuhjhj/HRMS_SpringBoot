package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.entity.Department;
import com.liuhjhj.hrms.entity.Staff;
import com.liuhjhj.hrms.service.implement.DepartmentServiceImplement;
import com.liuhjhj.hrms.service.implement.StaffServiceImplement;
import com.liuhjhj.hrms.service.implement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userprofile")
public class UserProfileController {

    private StaffServiceImplement staffServiceImplement;

    private DepartmentServiceImplement departmentServiceImplement;

    private UserServiceImplement userServiceImplement;

    @Autowired
    public void setStaffServiceImplement(StaffServiceImplement staffServiceImplement) {
        this.staffServiceImplement = staffServiceImplement;
    }

    @Autowired
    public void setDepartmentServiceImplement(DepartmentServiceImplement departmentServiceImplement) {
        this.departmentServiceImplement = departmentServiceImplement;
    }

    @Autowired
    public void setUserServiceImplement(UserServiceImplement userServiceImplement) {
        this.userServiceImplement = userServiceImplement;
    }

    @GetMapping("/{name}")
    public String toUserProfilePage(@PathVariable("name") String name, Model model){
        Staff userprofile = staffServiceImplement.getStaffById(userServiceImplement.getStaffId(name));
        System.out.println("toUserProfilePage");
        List<Department> departments = departmentServiceImplement.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("userprofile",userprofile);
        return "userprofile";
    }

    @PutMapping("/{name}")
    public String updateUserProfile(Staff staff){
        staffServiceImplement.updateStaff(staff);
        System.out.println("updateStaff:"+staff);
        return "userprofile";
    }

    //redirectAttributes.addFlashAttribute方法解决带参数重定向的问题
    @PutMapping("/reset_password")
    public String updatePassword(String password, String confirm, HttpSession session, RedirectAttributes redirectAttributes){
        String username = (String) session.getAttribute("username");
        if (userServiceImplement.updatePassword(username,password,confirm)){    //修改密码成功
            System.out.println("updatePassword:" + password);
            session.removeAttribute("username");
            redirectAttributes.addFlashAttribute("error", "reset_password_success");
            return "redirect:/login";
        }else {
            redirectAttributes.addFlashAttribute("msg","reset_password_fail");
            return "redirect:/userprofile/"+username;
        }

    }

}
