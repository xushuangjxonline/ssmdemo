package com.java.staffdepartmentmapping.dao;

import com.java.staffdepartmentmapping.model.StaffDepartmentMappingModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/3 - 16:10
 */
public interface StaffDepartmentDao {
    //删除单条的方法
    void deleteMapperModelByid(Integer sid);

    //查询bystaffid
    List<StaffDepartmentMappingModel> getMapperModelByid(Integer sid);

    //添加的方法
    void insertMapperModel(@Param("sid") Integer sid,@Param("did") Integer did);
}
