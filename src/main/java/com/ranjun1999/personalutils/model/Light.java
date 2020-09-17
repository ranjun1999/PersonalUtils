package com.ranjun1999.personalutils.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * 电灯
 * @Author: ranjun
 * @Date: 2020/8/10 13:58
 */
@Data
@NoArgsConstructor
public class Light {

    private String id;

    private String name;

    //电灯状态：true：打开，false:关闭
    private boolean status;

    //安装时间
    @JSONField(format = "yyyy-MM-dd")
    private Date installTime;

    private String typeDetailId;
}
