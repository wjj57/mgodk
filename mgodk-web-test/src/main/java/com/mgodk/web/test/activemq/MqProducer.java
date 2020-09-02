package com.mgodk.web.test.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Map;

//@Component
public class MqProducer {
//    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
//    @Autowired
    private Queue queue;
//    @Autowired
    private Topic topic;

//    @Scheduled(fixedDelay =3000)//设置定时任务 发送消息
    public void send() {
        String msg = System.currentTimeMillis() + "";
        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("点对点模式，生产者发送消息 ----- " + msg);
    }

    public void sendQueue(String msg) {
//        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("点对点模式，生产者发送消息 ----- " + msg);
    }

    public void sendQueue(String msg, Map<String,Object> header) throws Exception {
//        jmsMessagingTemplate.convertAndSend(queue,msg,header);
    }

    public void sendTopic(String msg) throws Exception {
//        jmsMessagingTemplate.convertAndSend(topic,msg);
        System.out.println("订阅模式，生产者发送消息 ----- " + msg);
    }

    public void sendTopic(String msg, Map<String,Object> header) throws Exception {
//        jmsMessagingTemplate.convertAndSend(topic,msg,header);
    }
}
