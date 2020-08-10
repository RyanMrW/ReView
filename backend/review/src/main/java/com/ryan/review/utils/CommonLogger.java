package com.ryan.review.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonLogger {
    private Logger logger;
    
    public CommonLogger(String className){
        logger = LoggerFactory.getLogger(className);
    }
    
    public void DebugLog(String tolog){
        logger.info(tolog);
    }
    
    public void SuccessLog(String reqName){
        JSONObject toLog = new JSONObject();
        toLog.put("req_name", reqName);
        toLog.put("req_status","success");
        logger.info(toLog.toString());
    }
    
    public void SuccessLog(String reqName, JSONObject reqMsg){
        JSONObject toLog = new JSONObject();
        toLog.put("req_name", reqName);
        toLog.put("req_msg",reqMsg);
        toLog.put("req_status","success");
        logger.info(toLog.toString());
    }
    
    public void BriefErrorLog(String reqName, JSONObject reqMsg, CodeMsg codeMsg){
        JSONObject toLog = new JSONObject();
        toLog.put("req_name", reqName);
        toLog.put("req_msg",reqMsg);
        toLog.put("resp_code",codeMsg);
        toLog.put("req_status","fail");
        logger.warn(toLog.toString());
    }
    
    public void DetailErrorLog(String reqName, JSONObject reqMsg, CodeMsg codeMsg, String detail){
        JSONObject toLog = new JSONObject();
        toLog.put("req_name", reqName);
        toLog.put("req_msg",reqMsg);
        toLog.put("resp_code",codeMsg);
        toLog.put("error_detail", detail);
        toLog.put("req_status","fail");
        logger.warn(toLog.toString());
    }
}
