
###启动类
    @SpringBootApplication
    @ComponentScan({"com.wzero","com.mgodk"}) //扫描 @Repository @Service @Controller @Component 等类到容器中
    @MapperScan("com.mgodk.biz.mapper") //扫描 mapper 接口，生成实现类及注入容器中（在非主程序下的包不能使用 @Mapper）
    @EnableTransactionManagement //开启 事务管理
    
    @EnableScheduling //开启 定时任务
    @EnableJms //开启 扫描触发使用@JmsListener注解的方法，创建消息监听器容器
    @EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true) //
###配置等其他类
    @Component
    @Configuration
###方法
    @Scheduled(fixedDelay =3000)
    @JmsListener(destination ="${activeMq.queue}",concurrency = "jmsLisContFactory")
    @ConfigurationProperties(prefix = "spring.activemq")

###属性
    @JsonIgnore //序列号忽略该字段


######ActiveMq 使用
    SpringBootApplication:@ComponentScan @EnableScheduling
    MqProducer:@Component @Scheduled
    MqCustomer:@Component @JmsListener
    *需要扫描到组件才能有作用，可以通过定时器进行发送消息，消费者自动接收消息


