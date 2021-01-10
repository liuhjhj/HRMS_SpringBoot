package com.liuhjhj.hrms.controller;

import com.liuhjhj.hrms.entity.Department;
import com.liuhjhj.hrms.entity.Staff;
import com.liuhjhj.hrms.service.implement.DepartmentServiceImplement;
import com.liuhjhj.hrms.service.implement.StaffServiceImplement;
import com.liuhjhj.hrms.service.implement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {

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

    //Get方式是获取页面
    @GetMapping("/staffs")
    public String toListPage(Model model, HttpSession session){
        List<Staff> staffs = staffServiceImplement.getStaffs();
        Integer staffId = userServiceImplement.getStaffId((String) session.getAttribute("username"));
        model.addAttribute("staffs",staffs);
        model.addAttribute("staffId",staffId);
        //员工的StaffList页面的TopBar的按钮类型是Add
        model.addAttribute("buttonAction","add");
        System.out.println("Get staffs:"+staffs);
        return "staff/list";
    }

    @GetMapping("/staff")
    public String toAddPage(Model model){
        List<Department> departments = departmentServiceImplement.getDepartments();
        model.addAttribute("departments",departments);
        //员工的StaffAdd页面的TopBar的按钮类型是Add
        model.addAttribute("buttonAction","back");
        return "staff/add";
    }

    //Post方式是添加数据
    @PostMapping("/staff")
    public String addStaff(Staff staff){
        staffServiceImplement.addStaff(staff);
        System.out.println("Add staff:"+staff);
        return "redirect:/staffs";
    }

    @GetMapping("/staff/{id}")
    //注解是PathVariable，不是Param
    //update和add共用一个页面
    public String toUpdatePage(@PathVariable("id") Integer id, Model model){
        Staff staff = staffServiceImplement.getStaffById(id);
        List<Department> departments = departmentServiceImplement.getDepartments();
        model.addAttribute("staff",staff);
        System.out.println("to update Staff page");
        model.addAttribute("departments",departments);
        //员工的StaffUpdate页面的TopBar的按钮类型是Back
        model.addAttribute("buttonAction","back");
        return "staff/add";
    }

    //Put方式是更新数据
    @PutMapping("/staff/{id}")
    public String updateStaff(Staff staff){
        staffServiceImplement.updateStaff(staff);
        System.out.println("update Staff:"+staff);
        return "redirect:/staffs";
    }

    //Delete方式是删除数据
    @DeleteMapping("/staff/{id}")
    public String deleteStaff(@PathVariable("id") Integer id){
        staffServiceImplement.deleteStaff(id);
        System.out.println("delete Staff:"+id);
        return "redirect:/staffs";
    }
}
