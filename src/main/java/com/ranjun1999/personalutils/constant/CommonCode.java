package com.ranjun1999.personalutils.constant;

/**
 * @Author: ranjun
 * @Date: 2020/8/5 16:26
 */
public enum CommonCode {
    C00000("00000", "操作成功"),
    C00001("00001", "操作失败"),
    C00002("00002", "登录过期"),
    C00003("00003", "参数验证失败"),
    C00004("00004", "非法的操作"),
    C00005("00005", "重复提交"),
    C00006("00006", "验证码错误"),
    C00007("00007", "验证码过期"),
    C00008("00008", "接口验证失败"),
    C00009("00009", "接口请求方法错误");

    private String code;
    private String message;

    private CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
