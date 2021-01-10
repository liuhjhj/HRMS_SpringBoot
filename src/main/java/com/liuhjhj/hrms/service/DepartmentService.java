package com.liuhjhj.hrms.service;

import com.liuhjhj.hrms.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();

    Department getDepartment(Integer id);

    void updateDepartment(Department department);

    void deleteDepartment(Integer id);
}
