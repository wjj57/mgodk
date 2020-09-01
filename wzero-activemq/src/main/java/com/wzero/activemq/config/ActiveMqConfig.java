package com.wzero.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**步骤：
 *      1、队列注入容器中；
 *      2、建立生产者、消费者；
 * JMS 通讯模式：
 *      1、消息队列，点对点模式；
 *      2、发布订阅，一对多模式；
 *      3、默认自动签收消息；
 *      4、手动签收模式；
 *      5、以事务形式发送或接受；
 */
@Configuration
public class ActiveMqConfig {

    @Value("${activeMq.queue}")
    private String queue;
    @Value("${activeMq.topic}")
    private String topic;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queue);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topic);
    }


    @ConfigurationProperties(prefix = "spring.activemq")
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        return connectionFactory;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(false);
        return factory;
    }
}
