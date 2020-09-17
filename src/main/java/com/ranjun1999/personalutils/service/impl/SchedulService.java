package com.ranjun1999.personalutils.service.impl;

import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ranjun
 * @Date: 2020/7/26 16:50
 */
@Service
@Slf4j
public class SchedulService {

    @Autowired
    MqttPushClient pushClient;

    public void sub(){
        log.info("----------订阅book" );
        pushClient.subscribe("book");
    }
}
