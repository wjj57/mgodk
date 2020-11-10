package com.mgodk.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import org.junit.Test;

/**
 * @ClassName RabbitMqTest
 * @Description
 * @Author WJJ
 * @Date 2020/11/02 16:17
 * @Version 1.0
 */
public class RabbitMqTest {
    private final static String EXCHANGE_NAME = "test_exchange_send";
    private final static String QUEUE_NAME = "test_queue_get";

    @Test
    public void test() throws Exception{
        dingYueSend();
    }

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/8081");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }

    public void dingYueSend() throws Exception {
        //获取连接以及通道
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        //声明 exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"dinyue");

        //消息内容
        String message = "Hello World";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("send --> " + message + " , ");
        //关闭
        channel.close();
        connection.close();
    }
    public void dingYueGet() throws Exception {
        //获取连接以及通道
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        //声明 队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        //定义队列消费者
        //监听队列，手动返回
        channel.basicConsume(QUEUE_NAME,false,null);

        //关闭
        channel.close();
        connection.close();
    }
}
