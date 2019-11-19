//package com.ranjun1999.personalutils.exception;
//
//import org.slf4j.LoggerFactory;
//
///**
// * create by tanwt
// * 2018/8/1 0001 21:38
// **/
//
///**
// * 自定义的常用异常
// */
//public class DefinedException extends RuntimeException {
//
//
//    private Integer code;
//
//    public DefinedException(ResultEnum resultEnum) {
//        super(resultEnum.getMsg());
//        this.code = resultEnum.getCode();
//    }
//
//    //正常错误返回
//    public DefinedException(ResultEnum resultEnum, Class<?> tClass) {
//        super(resultEnum.getMsg());
//        this.code = resultEnum.getCode();
//        LoggerFactory.getLogger(tClass).error(resultEnum.getMsg());
//    }
//
//    //运行时异常返回
//    public DefinedException(ResultEnum resultEnum, Class<?> tClass, Exception e) {
//        super(resultEnum.getMsg());
//        this.code = resultEnum.getCode();
//        LoggerFactory.getLogger(tClass).error(e.getMessage());
//    }
//
//    //自定义异常信息返回
//    public DefinedException(ResultEnum resultEnum, Class<?> tClass, String msg) {
//        super(msg);
//        this.code = resultEnum.getCode();
//        LoggerFactory.getLogger(tClass).error(msg);
//    }
//
//    public DefinedException(ResultEnum resultEnum, String msg) {
//        super(msg);
//        this.code = resultEnum.getCode();
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//}
