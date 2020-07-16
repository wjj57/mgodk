
###启动类
    @SpringBootApplication
    @ComponentScan({"com.wzero","com.mgodk"}) //扫描 加注解 @Component 的组件
    @EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true) //
    @EnableTransactionManagement //开启 事务管理
    @EnableScheduling //开启 定时任务
    @EnableJms //开启 扫描触发使用@JmsListener注解的方法，创建消息监听器容器
###配置等其他类
    @Component
    @Configuration
###方法
    @Scheduled(fixedDelay =3000)
    @JmsListener(destination ="${activeMq.queue}",concurrency = "jmsLisContFactory")
    @ConfigurationProperties(prefix = "spring.activemq")

######ActiveMq 使用
    SpringBootApplication:@ComponentScan @EnableScheduling
    MqProducer:@Component @Scheduled
    MqCustomer:@Component @JmsListener
    *需要扫描到组件才能有作用，可以通过定时器进行发送消息，消费者自动接收消息


