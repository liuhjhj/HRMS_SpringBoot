package com.liuhjhj.hrms.service.implement;

import com.liuhjhj.hrms.dao.StaffDao;
import com.liuhjhj.hrms.entity.Staff;
import com.liuhjhj.hrms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImplement implements StaffService {

    private StaffDao staffDao;

    @Autowired
    public void setStaffDao(StaffDao staffDao){
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> getStaffs() {
        return staffDao.getStaffs();
    }

    @Override
    public List<Staff> getStaffsWithoutUser() {
        return staffDao.getStaffsWithoutUser();
    }

    @Override
    public Staff getStaffById(Integer id) {
        return staffDao.getStaffById(id);
    }

    @Override
    public void addStaff(Staff staff) {
        staffDao.addStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }

    @Override
    public void deleteStaff(Integer id) {
        staffDao.deleteStaff(id);
    }
}
