package com.wzero.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestActiveMq {
    public static void main(String[] args) {
        try {
            producerSend();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void producerSend() throws Exception {
        String url = "tcp://127.0.0.1:61616";
        String queueName = "ACTIVE_QUEUE";//ACTIVE_QUEUE myQueue

        //1、创建连接工厂，账号密码采用默认admin-admin
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2、创建连接
        Connection connection = factory.createConnection();
        //启动连接
        connection.start();

        //3、创建会话
        //参数1设置是否需要以事务的方式提交；
        //参数2消息方式，自动签收 Session.AUTO_ACKNOWLEDGE，手动签收 Session.AUTO_ACKNOWLEDGE
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目标（队列）
        Queue queue = session.createQueue(queueName);
        //5、创建生产者
        MessageProducer producer = session.createProducer(queue);
        //设置消息是否需要持久化，默认为 DeliveryMode.PERSISTENT
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 10; i++) {
            //6、创建消息
            TextMessage textMessage = session.createTextMessage("消息内容，i = " + i);
            //7、发送消息
            producer.send(textMessage);
        }
        //8、关闭连接
        connection.close();
        System.out.println("消息发送完毕！");
    }

    public static void customerReceive() throws Exception {
        String url = "tcp://127.0.0.1:61616";
        String queueName = "myQueue";

        //1、创建连接工厂，账号密码采用默认admin
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2、创建连接
        Connection connection = factory.createConnection();
        //启动连接
        connection.start();

        //3、创建会话
        //参数1设置是否需要以事务的方式提交；
        //参数2消息方式，自动签收 Session.AUTO_ACKNOWLEDGE，手动签收 Session.CLIENT_ACKNOWLEDGE
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目标（队列）
        Queue queue = session.createQueue(queueName);
        //5、创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //启动消息监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage)message;
                    System.out.println("消费者接受到消息内容：" + textMessage.getText());
                    //textMessage.acknowledge();//手动签收
                } catch (Exception e) {
                }
            }
        });
    }
}
