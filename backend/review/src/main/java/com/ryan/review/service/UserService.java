package com.ryan.review.service;

import com.alibaba.fastjson.JSONObject;
import com.ryan.review.mapper.UserMapper;
import com.ryan.review.model.User;
import com.ryan.review.utils.CodeMsg;
import com.ryan.review.utils.CommonException;
import com.ryan.review.utils.CommonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    UserMapper userMapper;
    
    private CommonLogger commonLogger = new CommonLogger(this.getClass().getName());
    
    public List<User> getAllUsers() {
        return userMapper.GetAllUsers();
    }
    
    public User GetUserByName(String userName) {
        User user = userMapper.GetUserByName(userName);
        // 处理用户不存在
        if (user == null) {
            JSONObject requestJson = new JSONObject();
            requestJson.put("user_name", userName);
            commonLogger.BriefErrorLog("getUserByName", requestJson, CodeMsg.CM_NO_SUCH_USERNAME_USER);
            throw new CommonException(CodeMsg.CM_NO_SUCH_USERNAME_USER);
        }
        return user;
    }
    
    public int AddUser(User user) {
        try {
            return userMapper.AddUser(user);
        } catch (DuplicateKeyException e) {
            // 处理用户名重复
            JSONObject requestJson = new JSONObject();
            requestJson.put("user_name", user.getUserName());
            commonLogger.BriefErrorLog("addUser", requestJson, CodeMsg.CM_USER_USERNAME_EXIST);
            throw new CommonException(CodeMsg.CM_USER_USERNAME_EXIST);
        }
    }
    
    public int UpdateUserByUserID(User user) {
        JSONObject requestJson = new JSONObject();
        // 获取原来的user信息
        User originUser = userMapper.GetUserByID(user.getUserID());
        if (originUser == null) {
            requestJson.put("user_id", user.getUserID());
            commonLogger.BriefErrorLog("updateUserByName", requestJson, CodeMsg.CM_NO_SUCH_USERID_USER);
            throw new CommonException(CodeMsg.CM_NO_SUCH_USERID_USER);
        }
        // 进行拼装，补齐不需要修改的信息
        commonLogger.DebugLog(user.getUserName());
        if (user.getUserName() == null) {
            
            user.setUserName(originUser.getUserName());
        } else {
            User checkName = userMapper.GetUserByName(user.getUserName());
            if (checkName != null) {
                requestJson.put("user_name", user.getUserName());
                commonLogger.BriefErrorLog("updateUserByName", requestJson, CodeMsg.CM_USER_USERNAME_EXIST);
                throw new CommonException(CodeMsg.CM_USER_USERNAME_EXIST);
            }
        }
        if (user.getUserNickname() == null) {
            user.setUserNickname(originUser.getUserNickname());
        }
        if (user.getUserPassword() == null) {
            user.setUserPassword(originUser.getUserPassword());
        }
        if (user.getUserAvatar() == null) {
            user.setUserAvatar(originUser.getUserAvatar());
        }
        if (user.getUserRole() == 0 && originUser.getUserRole() != 0) {
            user.setUserRole(originUser.getUserRole());
        }
        return userMapper.UpdateUser(user);
    }
    
    public int DeleteUserByUserID(User user){
        return userMapper.DeleteUser(user);
    }
}
