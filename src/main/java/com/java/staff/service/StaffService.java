package com.java.staff.service;

import com.java.staff.model.StaffModel;
import com.java.utils.pageUtils.PageBean;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/1 - 21:05
 */
public interface StaffService {
    //查询整个员工列表
    List<StaffModel> selectStaffList();

    //查询分页显示
    PageBean selectStaffListByPaging(Integer pageNum);

    //根据ID查询员工信息
    StaffModel getStaffModelBySid(Integer sid);

    //添加员工信息
    void insertStaffModel(StaffModel staffModel);

    //修改员工信息
    void updateStaffModel(StaffModel staffModel);

    //删除员工信息
    void deleteStaffModel(Integer sid);

    //通过staffname属性获取sid
    Integer getSidByStaffname(String staffname);

}
