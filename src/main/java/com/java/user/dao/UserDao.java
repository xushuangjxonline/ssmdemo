package com.java.user.dao;

import com.java.user.model.UserModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author xs
 * @date 2019/9/17 - 19:00
 */

public interface UserDao {

    //返回所有管理员账号信息
    List<UserModel> selectUserList();
    //登录验证 是否有匹配的用户名和密码  匹配返回1
    Integer isAllowLogin(@Param("username")String username,@Param("password")String password );
    //根据ID返回该用户信息
    UserModel getUserModelByUid(Integer uid);
    //添加新管理员账号
    void insertUserModel(UserModel userModel);
    //修改管理员账号信息
    void updateUserModel(UserModel userModel);
    //删除管理员账号
    void  deleteUserModelByID(Integer uid);
}
