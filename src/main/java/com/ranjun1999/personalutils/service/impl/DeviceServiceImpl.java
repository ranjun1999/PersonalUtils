package com.ranjun1999.personalutils.service.impl;

import com.ranjun1999.personalutils.dao.DeviceDao;
import com.ranjun1999.personalutils.model.Device;
import com.ranjun1999.personalutils.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/7/20 13:48
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;

    @Override
    @Transactional
    public void insertDevice(Device device) {

        deviceDao.insertSelective(device);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertBatchDevice(List<Device> devices) {
//        deviceDao.insertBatchDevice(devices);
    }
}
