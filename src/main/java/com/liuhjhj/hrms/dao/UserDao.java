package com.liuhjhj.hrms.dao;

import com.liuhjhj.hrms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;

@Mapper
public interface UserDao {

    String getPassword(String username);

    void updatePassword(String username, String password);

    Integer getStaffId(String username);

    void addUser(User user);
}
