package com.liuhjhj.hrms.service.implement;

import com.liuhjhj.hrms.dao.UserDao;
import com.liuhjhj.hrms.entity.User;
import com.liuhjhj.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Integer getStaffId(String username) {
        return userDao.getStaffId(username);
    }

    @Override
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean userLogin(String username, String password) {
        return userDao.getPassword(username).equals(password);
    }

    @Override
    public Boolean updatePassword(String username, String password, String confirm) {
        if (password.equals(confirm)){  //两次输入的密码相同
            if (userDao.getPassword(username).equals(password)){    //新密码与原密码相等
                return false;
            }
            userDao.updatePassword(username,password);
            return true;
        }else {
            return false;
        }
    }
}
