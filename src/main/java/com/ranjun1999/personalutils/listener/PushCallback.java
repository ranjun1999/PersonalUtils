package com.ranjun1999.personalutils.listener;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;

/**
 * 消费监听类，在messageArrived方法中会收到mqtt中的数据，需要处理的话就在当前方法中操作
 * @Author: ranjun
 * @Date: 2020/7/26 13:46
 */
@Slf4j
@Component
public class PushCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        log.error(cause.getMessage(),cause);
//        try {
//            MqttPushClient.getClient().reconnect();
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 发送成功后回调
     * @param token
     */
    @SneakyThrows
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("----------"+ token.getMessageId() +" deliveryComplete：" + token.isComplete());
    }

    /**
     * 如果在订阅时，添加了IMqttMessageListener，这个方法会被覆盖
     * @param topic
     * @param message
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        log.info("----------- messageArrived: [topic:" + topic + ", messageId: " + message.getId() +" ,qos:" + message.getQos() + "，payLoad:" + new String(message.getPayload()) + "]");
    }
}
