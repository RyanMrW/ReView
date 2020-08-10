package com.ryan.review.model;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel
public class User {
    private int userID;
    private String userName;
    private String userNickname;
    private String userPassword;
    private Date userCreateTime;
    private String userAvatar;
    private int userRole;
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserNickname() {
        return userNickname;
    }
    
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public Date getUserCreateTime() {
        return userCreateTime;
    }
    
    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }
    
    public String getUserAvatar() {
        return userAvatar;
    }
    
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
    
    public int getUserRole() {
        return userRole;
    }
    
    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString() {
        return "User" + userID + ":" + "userName: " + userName;
    }
}
