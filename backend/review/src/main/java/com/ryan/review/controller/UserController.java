package com.ryan.review.controller;

import com.alibaba.fastjson.JSONObject;
import com.ryan.review.model.User;
import com.ryan.review.service.UserService;
import com.ryan.review.utils.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户管理接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private CommonLogger commonLogger = new CommonLogger(this.getClass().getName());
    
    @ApiOperation(value = "获取全部用户信息", notes = "获取用户信息列表")
    @GetMapping("/list")
    public CommonResp<List<User>> listUser() {
        List<User> users = userService.getAllUsers();
        commonLogger.SuccessLog("getAllUsers", new JSONObject());
        return new CommonResp<>(users);
    }
    
    @ApiOperation(value = "按用户名获取用户信息", notes = "{\"user_name\":\"admin\"}")
    @PostMapping("/get")
    public CommonResp<User> getUser(@RequestBody JSONObject requestJson) {
        // 检查参数
        CommonUtils.CheckPara("user_name",requestJson);
        User user = userService.GetUserByName(requestJson.getString("user_name"));
        commonLogger.SuccessLog("getUserByName", requestJson);
        return new CommonResp<>(user);
    }
    
    @ApiOperation(value = "添加用户", notes = " ")
    @PostMapping("/add")
    public CommonResp<Integer> addUser(@RequestBody User user) {
        CommonUtils.CheckParaStringNull("user_name",user.getUserName());
        CommonUtils.CheckParaStringNull("user_password",user.getUserPassword());
        int ret = userService.AddUser(user);
        commonLogger.SuccessLog("addUser");
        return new CommonResp<>(ret);
    }
    
    @ApiOperation(value = "修改用户", notes = " ")
    @PostMapping("/update")
    public CommonResp<Integer> UpdateUser(@RequestBody User user) {
        int ret = userService.UpdateUserByUserID(user);
        commonLogger.SuccessLog("updateUser");
        return new CommonResp<>(ret);
    }
    
    @ApiOperation(value = "删除用户", notes = " ")
    @PostMapping("/delete")
    public CommonResp<Integer> DeleteUser(@RequestBody User user) {
        int ret = userService.DeleteUserByUserID(user);
        commonLogger.SuccessLog("deleteUser");
        return new CommonResp<>(ret);
    }
}
