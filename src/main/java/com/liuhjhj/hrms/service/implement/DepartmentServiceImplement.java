package com.liuhjhj.hrms.service.implement;

import com.liuhjhj.hrms.dao.DepartmentDao;
import com.liuhjhj.hrms.entity.Department;
import com.liuhjhj.hrms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplement implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public Department getDepartment(Integer id) {
        return null;
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartment(Integer id) {

    }
}
