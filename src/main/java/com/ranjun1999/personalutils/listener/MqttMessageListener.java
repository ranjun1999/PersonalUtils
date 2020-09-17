package com.ranjun1999.personalutils.listener;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @Author: ranjun
 * @Date: 2020/8/5 16:47
 */
@Slf4j
public class MqttMessageListener implements IMqttMessageListener {

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        log.info("-----------" + s);
        log.info("-----------content" + mqttMessage.toString());
    }
}
