package com.ranjun1999.personalutils.service;

import com.ranjun1999.personalutils.model.Device;

import java.util.List;
import java.util.Map;

/**
 * @Author: ranjun
 * @Date: 2020/7/20 13:47
 */
public interface DeviceService {

    void insertDevice(Device device);
    void insertBatchDevice(List<Device> devices);

    ;
}
