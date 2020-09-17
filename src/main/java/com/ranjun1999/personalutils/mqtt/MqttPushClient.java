package com.ranjun1999.personalutils.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.ranjun1999.personalutils.listener.PushCallback;
import com.ranjun1999.personalutils.model.Light;
import com.ranjun1999.personalutils.service.LightService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;


/**
 *MQTT客户端
 * @Author: ranjun
 * @Date: 2020/7/26 13:45
 */
@Slf4j
public class MqttPushClient {

    @Autowired
    LightService lightService;

    private static MqttClient client;

    public static MqttClient getClient() {
        return client;
    }

    public static void setClient(MqttClient client) {
        MqttPushClient.client = client;
    }

    //创建连接
    public void connect(String host, String clientID, String username, String password, int timeout, int keepalive){
        MqttClient client;
        try {
            client = new MqttClient(host, clientID, new MemoryPersistence());
            //MQTT连接1设置
            MqttConnectOptions options = new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            //设置连接超时时间，单位为秒
            options.setConnectionTimeout(timeout);
            //设置会话心跳时间 单位为秒 服务器会每隔1.5* keepalive秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(keepalive);
            //设置遗愿主题与信息，客户端非正常断开连接时，服务器会向遗愿主题发布一条信息
//            options.setWill("testWill",(clientID + "----offline").getBytes(),0,true);
            MqttPushClient.setClient(client);
            client.setCallback(new PushCallback());
            client.connect(options);
        }catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 发布，默认qos为0，非retained
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic,String pushMessage){
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     * @param qos   发布消息的服务质量，即：保证消息传递的次数
     *              0：最多一次
     *              1：至少一次
     *              2：只有一次
     *
     * @param retained  发布保留标识，表示服务器要保留这次推送的信息，
     *                  如果有新的订阅者出现，就把这消息推送给它，如果设有那么推送至当前订阅者后释放
     * @param topic
     * @param pushMessage
     */
    public void publish(int qos,boolean retained,String topic,String pushMessage){
        MqttMessage message = new MqttMessage();
//        message.setId();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());
        MqttTopic mTopic = MqttPushClient.getClient().getTopic(topic);

        if(null == mTopic){
            log.error("topic not exist");
        }
        try {
            log.info("-----------publish message " + new String(message.getPayload()) + "to topic" + topic + "( Qos " + qos + ", Retained: " + retained + ")");
            client.publish(topic,message);
        } catch (MqttPersistenceException e) {
            log.info(e.getMessage(),e);
        } catch (MqttException e) {
            log.info(e.getMessage(),e);
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     * @param topic
     */
    public void subscribe(String topic){
        subscribe(topic,0);
    }

    /**
     * 订阅某个主题
     * @param topic
     * @param qos 服务器向自己转发消息时可以使用的最大QOS
     */
    public void subscribe(String topic,int qos){
        try {
            log.info("---------- subscribe to topic " + topic + "(QoS " + qos +")");
            MqttPushClient.getClient().subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量订阅
     * @param topics
     * @param qos
     */
    public void subscribeBatch(String[] topics, int[] qos) {
            try {
                if (qos == null || qos.length <= 0) {
                    client.subscribe(topics);
                    return;
                }
                client.subscribe(topics,qos);
            } catch (MqttException e) {
                log.error(e.getMessage(),e);
            }

    }

    /**
     * 取消订阅某个主题
     * @param topic
     */
    public void unSubscribe(String topic) {
        try {
            client.unsubscribe(topic);
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 批量取消订阅
     * @param topics
     */
    public void unSubscribeBatch(String[] topics) {
        try {
            client.unsubscribe(topics);
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 断开当前连接
     */
    public void disconnect() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 订阅电灯信息
     * @param topic
     * @param qos
     */
    public void lightInfoSubscribe(String topic, int qos) {
        try {
            client.subscribe(topic,qos, (s, msg) ->{
                String payLoad = new String(msg.getPayload());
                log.info("-----------messageArrived with topic " + s + "content: " + payLoad);
                Light light = JSONObject.parseObject(payLoad, Light.class);
                lightService.saveLightInfo(light);
            });

        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }

    public void mqttTest() throws Exception{
        MQTT mqtt = new MQTT();
        mqtt.setHost("tcp://localhost:1883");
        BlockingConnection connection = mqtt.blockingConnection();

        connection.connect();
    }

}
