package com.java.department.model;

/**
 * @author xs
 * @date 2019/9/17 - 18:07
 */
public class DepartmentModel {
    private Integer did;
    private String departmentname;
    private String info;

    @Override
    public String toString() {
        return "DepartmentModel{" +
                "did=" + did +
                ", departmentname='" + departmentname + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
