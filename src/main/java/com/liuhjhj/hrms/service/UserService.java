package com.liuhjhj.hrms.service;

import com.liuhjhj.hrms.entity.User;

public interface UserService {

    Boolean updatePassword(String username, String password, String confirm);

    Integer getStaffId(String username);

    Boolean addUser(User user);

    Boolean userLogin(String username, String password);
}
