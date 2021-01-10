package com.liuhjhj.hrms.service;

import com.liuhjhj.hrms.entity.User;

public interface UserService {

    public String getPassword(String username);

    public Boolean updatePassword(String username, String password, String confirm);

    public Integer getStaffId(String username);

    public Boolean addUser(User user);

    public Boolean userLogin(String username, String password);
}
