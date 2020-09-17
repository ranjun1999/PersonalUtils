package com.ranjun1999.personalutils.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ranjun1999.personalutils.model.User;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;

/**
 * @Author: ranjun
 * @Date: 2020/5/20 17:52
 */
public interface UserService  {

    User getUser();

    void login(User user);

    void addUser(User user);

    IPage<User> selectUserPage(Page<User> userPage);
}
