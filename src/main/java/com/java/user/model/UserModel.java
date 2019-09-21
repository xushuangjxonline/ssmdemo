package com.java.user.model;

/**
 * @author xs
 * @date 2019/9/17 - 18:11
 */
public class UserModel {
    private Integer uid;
    private String username;
    private String password;
    private String power;
    private Integer is_superAdmin;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }



    public void setPower(String power) {
        this.power = power;
    }

    public Integer getIs_superAdmin() {
        return is_superAdmin;
    }

    public void setIs_superrAdmin(Integer is_superAdmin) {
        this.is_superAdmin = is_superAdmin;
    }

}

