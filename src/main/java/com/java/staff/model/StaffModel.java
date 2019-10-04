package com.java.staff.model;

import com.java.staffdepartmentmapping.model.StaffDepartmentMappingModel;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/1 - 20:56
 */
public class StaffModel {
    private Integer sid;
    private String staffname;
    private String gender;
    private String email;
    private String photo;
    private String salary;
    private List<StaffDepartmentMappingModel> staffDepartmentMappingModelList;

    @Override
    public String toString() {
        return "StaffModel{" +
                "sid=" + sid +
                ", staffname='" + staffname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", salary='" + salary + '\'' +
                ", staffDepartmentMappingModelList=" + staffDepartmentMappingModelList +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<StaffDepartmentMappingModel> getStaffDepartmentMappingModelList() {
        return staffDepartmentMappingModelList;
    }

    public void setStaffDepartmentMappingModelList(List<StaffDepartmentMappingModel> staffDepartmentMappingModelList) {
        this.staffDepartmentMappingModelList = staffDepartmentMappingModelList;
    }
}
