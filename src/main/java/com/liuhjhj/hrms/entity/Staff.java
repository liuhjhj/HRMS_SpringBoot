package com.liuhjhj.hrms.entity;

import java.util.Date;

public class Staff {

    Integer id;
    String name;
    Integer gender;
    Integer age;
    Department department;

    public Staff() {
    }

    public Staff(Integer id, String name, Integer gender, Integer age, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
