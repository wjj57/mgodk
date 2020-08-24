package com.mgodk.web.test.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class MqCustomer {
    @JmsListener(destination ="${activeMq.queue}")
    public void receiveQueue(String msg) {
        System.out.println("点对点模式，消费者 成功获取到消息 ----- " + msg);
    }
    @JmsListener(destination ="${activeMq.queue}")
    public void receiveQueue2(String msg) {
        System.out.println("点对点模式，消费者222 成功获取到消息 ----- " + msg);
    }

    @JmsListener(destination ="${activeMq.topic}")
    public void receiveTopic(String msg) {
        System.out.println("订阅模式，消费者 成功获取到消息 ----- " + msg);
    }
    @JmsListener(destination ="${activeMq.topic}")
    public void receiveTopic2(String msg) {
        System.out.println("订阅模式，消费者222 成功获取到消息 ----- " + msg);
    }
    @JmsListener(destination ="${activeMq.topic}")
    public void receiveTopic3(String msg) {
        System.out.println("订阅模式，消费者333 成功获取到消息 ----- " + msg);
    }
}
