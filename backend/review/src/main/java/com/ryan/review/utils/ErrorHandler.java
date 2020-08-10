package com.ryan.review.utils;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ErrorHandler {
    @ExceptionHandler(value = Exception.class)
    public CommonResp<String> defaultErrorHandler(HttpServletRequest req, Exception e) {
        String errorPosition = e.toString();
        //如果错误堆栈信息存在
        if (e.getStackTrace().length > 0) {
            StackTraceElement element = e.getStackTrace()[0];
            String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
            int lineNumber = element.getLineNumber();
            errorPosition = errorPosition +" " + fileName + ":" + lineNumber;
        }
        return new CommonResp<>(errorPosition, CodeMsg.CM_SYS_INTERNAL_ERROR);
    }
    
    /**
     * GET/POST请求方法错误的拦截器
     * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
     * 所以定义了这个拦截器
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResp<String> httpRequestMethodHandler() {
        return new CommonResp<>(CodeMsg.CM_SYS_METHOD_UNSUPPORT);
    }
    
    /**
     * 本系统自定义错误的拦截器
     * 拦截到此错误之后,就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     */
    @ExceptionHandler(CommonException.class)
    public CommonResp<String> commonRespHandler(CommonException commonException) {
        return new CommonResp<>(commonException.getInfo(),commonException.getCodeMsg());
    }

    
}
