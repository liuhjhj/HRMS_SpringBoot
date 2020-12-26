package com.liuhjhj.hrms.entity;

public class User {

    private String username;
    private String password;
    private Integer staffId;

    public User() {
    }

    public User(String username, String password, Integer staffId) {
        this.username = username;
        this.password = password;
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", staffId=" + staffId +
                '}';
    }
}
