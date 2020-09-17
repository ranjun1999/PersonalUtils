package com.ranjun1999.personalutils.config;

import com.ranjun1999.personalutils.listener.MqttMessageListener;
import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * MQTT配置类
 * @Author: ranjun
 * @Date: 2020/7/26 13:28
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "mqtt")
@Data
@Slf4j
public class MqttConfig {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 连接地址
     */
    private String host;
    /**
     * 客户Id
     */
    private String clientID;
    /**
     * 默认连接话题
     */
    private String defaultTopic;
    /**
     * 超时时间
     */
    private int timeout;
    /**
     * 保持连接数
     */
    private int keepalive;


    @Bean
    public MqttPushClient getMqttPushClient(){
        MqttPushClient mqttPushClient = new MqttPushClient();
//        mqttPushClient.connect(host, clientID, username, password, timeout,keepalive);
        return mqttPushClient;
    }

    @Bean
    public IMqttMessageListener getMqttMessageListener() {
        return new MqttMessageListener();
    }

}
