package com.ranjun1999.personalutils.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ranjun1999.personalutils.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/3/22 9:30
 */
@Repository
public interface UserDao extends BaseMapper<User>{

    void insertUser(@Param("u") User u);

    User getUser(User user);

    List<User> selectUsers(int start, int pageSize);

    void modifyUser(User u);

    IPage<User> selectPageVo(Page<?> userPage);

}
