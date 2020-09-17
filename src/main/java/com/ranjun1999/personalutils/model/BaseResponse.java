package com.ranjun1999.personalutils.model;

import com.ranjun1999.personalutils.constant.CommonCode;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @Author: ranjun
 * @Date: 2020/8/5 16:20
 */
@Data
public class BaseResponse<T> {

    //状态
    private Boolean status;

    //消息
    private String message;

    //状态码
    private String code;

    //返回数据
    T data;

    public static <T> BaseResponse<T> ok() {
        return ok((String) null);
    }

    public static <T> BaseResponse<T> ok(String message) {
        return ok(message, null);
    }

    public static <T> BaseResponse<T> ok(String message, T data) {
        BaseResponse<T> instance = instance(CommonCode.C00000,data);
        if (!StringUtils.isEmpty(message)) {
            instance.setMessage(message);
        }
        return instance;
    }

    public static <T> BaseResponse<T> data(T data) {
        return ok((String) null, data);
    }

    public static <T> BaseResponse<T> failed() {
        return failed((String) null);
    }

    public static <T> BaseResponse<T> failed(String message) {
        return failed((String) null, message);
    }

    public static <T> BaseResponse<T> failed(String code, String message) {
        BaseResponse<T> response = instance(CommonCode.C00001, null);
        if (!StringUtils.isEmpty(code)) {
            response.setCode(code);
        }

        if (!StringUtils.isEmpty(message)) {
            response.setMessage(message);
        }

        response.setStatus(false);
        return response;
    }


    private static <T> BaseResponse<T> instance(CommonCode codeObject) {
        return instance(codeObject, null);
    }

    private static <T> BaseResponse<T> instance(CommonCode codeObject, T data) {
        Objects.requireNonNull(codeObject, "parameter [codeObject] can not be null!");
        BaseResponse<T> response = new BaseResponse();
        response.setStatus(codeObject.getCode().endsWith(CommonCode.C00000.getCode()));
        response.setMessage(codeObject.getMessage());
        response.setCode(codeObject.getCode());
        response.setData(data);
        return response;
    }



}
