package com.java.staffdepartmentmapping.model;

import com.java.department.model.DepartmentModel;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/3 - 15:57
 */
public class StaffDepartmentMappingModel {
    private Integer id;
    private Integer staffid;
    private Integer departmentid;
    private List<DepartmentModel> departmentModelList;

    @Override
    public String toString() {
        return "StaffDepartmentMappingModel{" +
                "id=" + id +
                ", staffid=" + staffid +
                ", departmentid=" + departmentid +
                ", departmentModelList=" + departmentModelList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public List<DepartmentModel> getDepartmentModelList() {
        return departmentModelList;
    }

    public void setDepartmentModelList(List<DepartmentModel> departmentModelList) {
        this.departmentModelList = departmentModelList;
    }
}
