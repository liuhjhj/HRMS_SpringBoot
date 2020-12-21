package com.liuhjhj.hrms.dao;

import com.liuhjhj.hrms.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    List<Department> getDepartments();

    Department getDepartment(Integer id);

    void updateDepartment(Department department);

    void deleteDepartment(Integer id);
}
