package com.ryan.review.utils;

public class CommonException extends RuntimeException {
    private CodeMsg codeMsg;
    private String info;
    
    public CommonException(CodeMsg codeMsg){
        this.codeMsg = codeMsg;
        this.info = "";
    }
    
    public CommonException(CodeMsg codeMsg, String info){
        this.codeMsg = codeMsg;
        this.info = info;
    }
    
    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
    
    public String getInfo() {
        return info;
    }
}
