package com.liuhjhj.hrms.dao;

import com.liuhjhj.hrms.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StaffDao {

    List<Staff> getStaffs();

    Staff getStaffById(Integer id);

    Staff getStaffByName(String name);

    void addStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(Integer id);
}
