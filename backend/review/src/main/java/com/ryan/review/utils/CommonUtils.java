package com.ryan.review.utils;


import com.alibaba.fastjson.JSONObject;

public class CommonUtils {
    public static void CheckPara(String paraName, JSONObject req) {
        Object ans = req.get(paraName);
        if (ans == null) {
            throw new CommonException(CodeMsg.CM_SYS_MSSING_PARA, "Missing " + paraName);
        }
    }
    
    public static void CheckParaMissing(String paraName, Object obj) {
        if (obj == null) {
            throw new CommonException(CodeMsg.CM_SYS_MSSING_PARA, "Missing " + paraName);
        }
    }
    
    public static void CheckParaStringNull(String paraName, String str) {
        if (str == null) {
            throw new CommonException(CodeMsg.CM_SYS_MSSING_PARA, "Missing " + paraName);
        }
        if (str.equals("")) {
            throw new CommonException(CodeMsg.CM_SYS_MSSING_PARA, "String " +
                    paraName + "should not be empty.");
        }
    }
}
