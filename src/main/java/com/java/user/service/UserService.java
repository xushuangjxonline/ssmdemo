package com.java.user.service;

import com.java.user.model.UserModel;

import java.util.List;

/**
 * @author xs
 * @date 2019/9/18 - 7:11
 */

public interface UserService {

    //返回所有管理员列表
    List<UserModel> selectUserList();

    //管理员登陆判断
    Integer isAllowLogin(String username , String password);

    //根据ID查询
    UserModel getUserModelByUid(Integer uid);

    //添加管理员
    void insertUserModel(UserModel userModel);

    //修改管理员信息
    void updateUserModel(UserModel userModel);

    //删除管理员信息
    void deleteUserModelByID(Integer uid);
}
