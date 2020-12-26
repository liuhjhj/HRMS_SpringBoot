package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.dao.DepartmentDao;
import com.liuhjhj.hrms.dao.StaffDao;
import com.liuhjhj.hrms.dao.UserDao;
import com.liuhjhj.hrms.entity.Department;
import com.liuhjhj.hrms.entity.Staff;
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

    private StaffDao staffDao;

    private DepartmentDao departmentDao;

    private UserDao userDao;

    @Autowired
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{name}")
    public String toUserProfilePage(@PathVariable("name") String name, Model model){
        Staff userprofile = staffDao.getStaffById(userDao.getStaffId(name));
        System.out.println("toUserProfilePage");
        List<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("userprofile",userprofile);
        return "userprofile";
    }

    @PutMapping()
    public String updateUserProfile(Staff staff){
        staffDao.updateStaff(staff);
        System.out.println("updateStaff:"+staff);
        return "redirect:/userprofile/"+staff.getName();
    }

    //redirectAttributes.addFlashAttribute方法解决带参数重定向的问题
    @PutMapping("/reset_password")
    public String updatePassword(String password, String confirm, HttpSession session, RedirectAttributes redirectAttributes){
        String username = (String) session.getAttribute("username");
        if (!password.equals(confirm)){ //两次输入的密码不相同
            redirectAttributes.addFlashAttribute("msg","password_is_not_match");
        }else if (password.equals(userDao.getPassword(username))){  //新密码与原密码相等
            redirectAttributes.addFlashAttribute("msg","same_password");
        }else { //修改密码
            userDao.updatePassword(username, password);
            System.out.println("updatePassword:" + password);
            session.removeAttribute("username");
            redirectAttributes.addFlashAttribute("error", "reset_password_success");
            return "redirect:/login";
        }
        return "redirect:/userprofile/"+username;
    }

}
