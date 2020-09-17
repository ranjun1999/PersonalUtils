package com.ranjun1999.personalutils.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ranjun1999.personalutils.dao.UserDao;
import com.ranjun1999.personalutils.model.User;
import com.ranjun1999.personalutils.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: ranjun
 * @Date: 2020/5/20 17:58
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserDao userDao;


    @Override
    public User getUser() {
//        return userDao.selectById("1");
        return null;
    }

    @Override
    public void login(User user) {


    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.insertUser(user);
        LOGGER.info("插入完成");
        int a = 10/0;
    }


    @Override
    public IPage<User> selectUserPage(Page<User> userPage) {

        return userDao.selectPage(userPage,null);
    }
}
