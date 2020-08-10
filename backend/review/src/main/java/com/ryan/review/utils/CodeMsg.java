package com.ryan.review.utils;

public enum CodeMsg {
    // 成功
    CM_SUCCESS("200",""),
    
    // 系统通用类,code 400XX
    CM_SYS_INTERNAL_ERROR("40000","内部错误"),
    CM_SYS_MSSING_PARA("40001","缺失参数"),
    CM_SYS_METHOD_UNSUPPORT("40002","不支持GET/POST方法，请检查"),
    
    // user类,code 401XX
    CM_NO_SUCH_USERNAME_USER("40100","用户名不存在"),
    CM_NO_SUCH_USERID_USER("40101","用户ID不存在"),
    CM_USER_USERNAME_EXIST("40102","用户名已存在"),
    
    ;
    
    private String errorCode;
    
    private String errorMsg;
    
    CodeMsg(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public String getCode() {
        return errorCode;
    }
    
    public String getMsg() {
        return errorMsg;
    }
    
}
