package com.ranjun1999.personalutils.service.impl;

import com.ranjun1999.personalutils.mqtt.ClientMqtt;
import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: ranjun
 * @Date: 2020/7/28 14:07
 */
@Service
@Slf4j
public class MqttService {

    @Autowired
    MqttPushClient mqttPushClient;

    @Scheduled(fixedDelayString = "2000")
    public void publishMessage() {
        ClientMqtt cm = new ClientMqtt();
        String cliendId = ClientMqtt.CLIENT_ID + (int)Math.random()*10;
        cm.connect(ClientMqtt.HOST,cliendId ,ClientMqtt.USERNAME,ClientMqtt.PASSWORD);
        log.info("------------" + cliendId + "连接成功");
    }
}
