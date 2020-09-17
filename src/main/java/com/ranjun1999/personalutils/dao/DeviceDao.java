package com.ranjun1999.personalutils.dao;

import com.ranjun1999.personalutils.model.Device;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao {

    int insert(Device record);

    int insertSelective(Device record);


}