package com.java.user.service.impl;

import com.java.user.dao.UserDao;
import com.java.user.model.UserModel;
import com.java.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xs
 * @date 2019/9/18 - 7:14
 */
@Controller
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public  List<UserModel> selectUserList(){
        return userDao.selectUserList();
    }

    @Override
    public Integer isAllowLogin(String username, String password) {

        return userDao.isAllowLogin(username, password);
    }

    @Override
    public UserModel getUserModelByUid(Integer uid) {
        return userDao.getUserModelByUid(uid);
    }

    @Override
    public void insertUserModel(UserModel userModel) {
        userDao.insertUserModel(userModel);
    }

    @Override
    public void updateUserModel(UserModel userModel) {
        userDao.updateUserModel(userModel);
    }

    @Override
    public void deleteUserModelByID(Integer uid) {
        userDao.deleteUserModelByID(uid);
    }
}
