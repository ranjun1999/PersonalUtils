package com.ranjun1999.personalutils.controller;

import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import com.ranjun1999.personalutils.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ranjun
 * @Date: 2020/7/26 13:56
 */
@RestController
@Slf4j
public class MqttController {

    @Autowired
    private MqttPushClient mqttPushClient;

    /**
     * 发布消息
     * @param topic 主题
     * @param message   内容
     * @return
     */
    @GetMapping ("/publish")
    public BaseResponse sendMessage(String topic, String message, int qos){
        mqttPushClient.publish(qos,false,topic, message);
        return BaseResponse.ok("发布成功");
    }


    @GetMapping("/subscribe")
    public BaseResponse subscribeMessage(String topic, int qos) {
        log.info("---------订阅:" + topic);
        mqttPushClient.subscribe(topic, qos);
        return BaseResponse.ok("订阅成功");
    }

    @GetMapping("/unsubscribe")
    public BaseResponse ubSubscribe(String topic) {
        log.info("-----------取消订阅" + topic);
        mqttPushClient.unSubscribe(topic);
        return BaseResponse.ok("取消成功");
    }

    @GetMapping("/disconnect")
    public BaseResponse disconnect(){
        log.info("-----------断开连接");
        mqttPushClient.disconnect();
        return BaseResponse.ok("断开成功");
    }

}
