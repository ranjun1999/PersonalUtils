//package com.ranjun1999.personalutils.handler;
//
///**
// * create by tanwt
// * 2018/10/8 0008 22:18
// **/
//
//
//import com.ranjun1999.personalutils.exception.DefinedException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 自定义的全局异常捕获
// * 所有的异常都会被这个类捕获处理
// */
//@CrossOrigin
//@RestControllerAdvice
//public class DefinedExceptionHander {
//
//    /**
//     * 自定义异常
//     */
//    @ExceptionHandler(DefinedException.class)
//    public Map<String, Object> httpRequestMethodNotSupportedExceptionHandler(DefinedException e) {
//        Map<String, Object> attributes;
//        attributes = setExceptionResp(e.getCode(), e.getMessage());
//        return attributes;
//    }
////
////    @ExceptionHandler  //处理其他异常
////    public Map<String, Object> allExceptionHandler(Exception e) {
////        Map<String, Object> attributes;
////        e.printStackTrace();
////        attributes = setExceptionResp(ResultEnum.UNKNOW_ERROR.getCode(), e.getMessage());
////        return attributes;
////    }
//
//
//    private Map<String, Object> setExceptionResp(int code, String msg) {
//        Map<String, Object> errorResult = new HashMap<String, Object>();
//        errorResult.put("code", code);
//        errorResult.put("msg", msg);
//        errorResult.put("data", "null");
//        return errorResult;
//    }
//}
