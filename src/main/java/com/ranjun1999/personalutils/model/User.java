package com.ranjun1999.personalutils.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: ranjun
 * @Date: 2020/5/20 17:12
 */
@TableName("user")
@Data
public class User {

    @TableId(value = "user_id",type = IdType.ID_WORKER_STR)
    private String userId;

    @TableField(value = "user_name")
    private String userName;

    private String password;

    private String email;

    private Integer age;
    private Date birth;

}
