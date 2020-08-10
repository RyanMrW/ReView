package com.ryan.review.utils;

public class CommonResp<T> {
    private String code;
    private String msg;
    private T info;
    
    public CommonResp(){
        this.code = CodeMsg.CM_SUCCESS.getCode();
        this.msg = CodeMsg.CM_SUCCESS.getMsg();
        this.info = null;
    }
    
    public CommonResp(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.info = null;
    }
    
    public CommonResp(T info){
        this.code = CodeMsg.CM_SUCCESS.getCode();
        this.msg = CodeMsg.CM_SUCCESS.getMsg();
        this.info = info;
    }
    
    public CommonResp(T info, CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.info = info;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getInfo() {
        return info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
}
