package com.liuhjhj.hrms.service;

import com.liuhjhj.hrms.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getStaffs();

    List<Staff> getStaffsWithoutUser();

    Staff getStaffById(Integer id);

    void addStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(Integer id);
}
