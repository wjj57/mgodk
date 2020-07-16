package com.mgodk.web.test.activemq;

import com.wzero.activemq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.mgodk.web.test.activemq
 * @ClassName MqController
 * @Description
 * @Author WJJ
 * @Date 2020/7/16 16:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private Producer producer;

    @RequestMapping("/sendQueue")
    public void sendQueue() {
        producer.send();
        System.out.println("==========》   消息发送成功！");
    }
}
