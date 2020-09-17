package com.ranjun1999.personalutils.mqtt;

import com.ranjun1999.personalutils.listener.PushCallback;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @Author: ranjun
 * @Date: 2020/7/29 15:07
 */
@Slf4j
public class ClientMqtt {

    public static final String HOST = "tcp://127.0.0.1:1883";
    public static final String CLIENT_ID = "client";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "991718";

    public static final String WILL_TOPIC = "testWill";
    public static final String WILL_MESSAGE = CLIENT_ID +"断开连接了";
    public static final boolean WILL_RETAINED = true;
    public static final int WILL_QOS = 0;

    private MqttClient client;
    private MqttConnectOptions options;

    public void connect(String hostUrl,String clientId,String userName, String passWord) {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientId, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，创建持久性会话；这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5* KeepAlive秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(60);
            //设置遗愿信息
//            options.setWill(WILL_TOPIC,(clientId + WILL_MESSAGE).getBytes(),WILL_QOS,WILL_RETAINED);
            // 设置回调
            client.setCallback(new PushCallback());
            client.connect(options);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    public void disConnect(){
        try {
            client.disconnect();
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }

    public void publish(int qos,boolean retained,String topic,String pushMessage){
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());
        MqttTopic mTopic = client.getTopic(topic);

        if(null == mTopic){
            log.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            log.error(e.getMessage(),e);
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }
    /**
     * 订阅某个主题
     * @param topic
     * @param qos
     */
    public void subscribe(String topic,int qos){
        try{
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            log.error(e.getMessage(),e);
        }
    }
    public MqttClient getClient() {
        return client;
    }

    public static void main(String[] args) throws MqttException {
        for (int i = 0; i < 10; i++) {
            ClientMqtt client = new ClientMqtt();
            String clientId = CLIENT_ID + i;
            client.connect(HOST,clientId,USERNAME,PASSWORD);
            log.info("----------" + clientId + "连接成功");
            client.subscribe("light/info",1);
        }
    }
}
