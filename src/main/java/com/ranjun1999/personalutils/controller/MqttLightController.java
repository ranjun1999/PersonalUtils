package com.ranjun1999.personalutils.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ranjun1999.personalutils.model.BaseResponse;
import com.ranjun1999.personalutils.model.Light;
import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ranjun
 * @Date: 2020/8/10 14:16
 */
@RestController
@RequestMapping("light")
public class MqttLightController {

    @Autowired
    MqttPushClient mqttPushClient;


    @RequestMapping("/status/onPub")
    public BaseResponse lightsOn(String lightTypeId) {
        Light light = new Light();
        light.setTypeDetailId(lightTypeId);
        light.setStatus(true);
        mqttPushClient.publish(1,false,"light/status", JSONObject.toJSONString(light));
        return BaseResponse.ok();
    }

    @RequestMapping("/status/offPub")
    public BaseResponse ligthOff(String lightTypeId) {
        Light light = new Light();
        light.setTypeDetailId(lightTypeId);
        light.setStatus(false);
        mqttPushClient.publish(1,false,"light/status", JSONObject.toJSONString(light));
        return BaseResponse.ok();
    }

    /**
     * 订阅电灯信息
     * @return
     */
    @GetMapping("/status/infoSub")
    public BaseResponse getStatus() {
        mqttPushClient.lightInfoSubscribe("light/status/info", 1);
        return BaseResponse.ok();
    }

    /**
     * 设置电灯信息
     * @return
     */
    @PostMapping("/status/infoPub")
    public BaseResponse updateStatus(@RequestBody Light light) {
        mqttPushClient.publish(1,false,"light/status/info",JSONObject.toJSONString(light));
        return BaseResponse.ok();
    }
}
