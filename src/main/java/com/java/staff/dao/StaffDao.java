package com.java.staff.dao;

import com.java.staff.model.StaffModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/1 - 21:01
 */
public interface StaffDao {
    //查询整个员工列表
    List<StaffModel> selectStaffList();

    //分页查询方法
    List<StaffModel> selectStaffListByPaging(@Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);

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
