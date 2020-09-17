package com.ranjun1999.personalutils.service.impl;

import com.alibaba.excel.EasyExcel;
import com.ranjun1999.personalutils.listener.NoModelDataListener;
import com.ranjun1999.personalutils.model.Device;
import com.ranjun1999.personalutils.model.User;
import com.ranjun1999.personalutils.service.DeviceService;
import com.ranjun1999.personalutils.service.ExcelLoadService;
import com.ranjun1999.personalutils.service.UserService;
import com.ranjun1999.personalutils.utils.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: ranjun
 * @Date: 2020/7/21 13:39
 */
@Service
public class ExcelLoadServiceImpl implements ExcelLoadService {

    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    /**
     * 默认一行一行的读取Excel，所以需要创建excel一行一行的回调监听器
     * @param filePath
     */
    @Override
    public void deviceLoad(String filePath) {
        NoModelDataListener loadListener = new NoModelDataListener(this) ;
        //默认读取第一个sheet
        EasyExcel.read(filePath,loadListener).sheet().doRead();

//        List<Map<Integer,Object>> list = loadListener.getList();
    }


    @Override
    @Transactional
    public void insertExcelData(List<Map<Integer, String>> list) {
        User user = new User();
        user.setUserId("7");
        user.setUserName("ranj");
        userService.addUser(user);
    }

    @Override
    public void saveParkData(List<Map<Integer, String>> list) {

        if (list != null && list.size() > 0) {
            Iterator<Map<Integer, String>> iter = list.iterator();
            while (iter.hasNext()) {
                Map<Integer, String> map = iter.next();
                PrintUtil.pringMap(map);
            }
        }
    }
}
