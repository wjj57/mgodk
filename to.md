## 使用及问题
前后端分离，多模块开发

    bootall     集中式系统               -127.0.0.1:80..
    util        工具类
    entity      实体类（公共API接口）
    dao         数据操作类 -entity
    service     业务服务类 -dao、util
    web         应用表示类 -service      -127.0.0.1:8090
    activemq    消息队列                -127.0.0.1:8091
    solr        搜索应用                -127.0.0.1:8092
    
    SpringCloud 微服务架构使用：
    mforg-entity    公共API接口
    cloud-provider  服务提供者 -entity       -127.0.0.1:8001     -EurekaClient,
    cloud-provider2 服务提供者2 -entity      -127.0.0.1:8002     -EurekaClient,
    cloud-provider-h服务提供者h -entity      -127.0.0.1:8003     -EurekaClient,Hystrix,
    
    cloud-consumer  服务消费者 -entity       -127.0.0.1:80       -EurekaClient,Ribbon,
    cloud-consumer-f服务消费者f -entity      -127.0.0.1:81       -EurekaClient,Ribbon,Feign,
    Cloud-consumer-h-d 服务消费者f -entity   -127.0.0.1:82       -EurekaClient,Ribbon,Feign,Hystrix,Dashboard
    
    cloud-eureka    服务注册                 -127.0.0.1:7001     -EurekaServer,
    cloud-eureka2   服务注册2                -127.0.0.1:7002     -EurekaServer,
    cloud-zuul      路由网关                 -127.0.0.1:9527     -Zuul,EurekaServer,Hystrix,
    cloud-config    配置中心                 -127.0.0.1:3344     -ConfigServer, EurekaServer,Hystrix,
    cloud-config-c  配置中心客户端             -127.0.0.1:8201     -Config, EurekaServer,Hystrix,

    127.0.0.1	mforg.com,myport.com,myport11.com,myport22.com,myport33.com,myport44.com,
            myport55.com,myport66.com,myport77.com,myport88.com,myport99.com,

##### 实现功能
    1、系统模块开发，搭配运行环境；
    2、数据处理办法：
        -对象实体 用关系数据库Mysql；
        -缓存数据 用非关系数据库Redis或文件存储；
    3、基本框架确认：
        -SpringBoot + SSM ，tk-mybatis；
        -前端以Bootstrap为基础，扩展添加；
        -后端拓展框架看需求添加；
    4、SpringSecurity：
        -账户密码验证；验证码验证；记住我；
        -Url权限控制验证；
    5、用户单点登录，SSO；
    6、消息队列，ActiveMQ 框架；
    7、系统搜索 solr 框架；
    8、丰富前端页面；
###### 注：
    Redis 配置成功，需整合添加缓存设置和缓存数据；
    ActiveMQ 编写完成，需分离系统，负责发送和监听处理；
    Security 普通需求完成，需完成URL权限验证和记住密码；
    solr 搜索，可以省略，安装搭建环境较为繁琐

##### 代码
    common  -返回前台数据包装、静态常量
    util    -工具类
                验证码生成工具；
                文件上传、下载；表格导入、导出；
                密码加密、解密；验证码生成；
    其他     -拦截器

##### 框架功能
    security    -权限验证 shiro/spring-security/
    activeMq    -消息队列 Mq
    sso         -单点登录
    redis       -缓存
    solr        -搜索
    dubbo/zookeeper/webservice/springcloud/
    hibernate/struts/
    打印文件
    html转文件、图片

##### 前端页面
    前端框架   -bootstrap、vue、easyUI
    表格      -strap.table;
    消息窗口   -toastr
    树状列表   -tree、strap.treeview;
    表单验证   -strap.validator
    时间日历   -strap.datetimepicker
    上传      -strap.fileinput
    会话窗口   -dialog
    选择      -strap.select
    图表      -echart;
    图片查看器 -viewer;
    富文本框   -ueditor-utf-8
    开关按钮   -honeySwitch
    其他      -strap.iconpicker、numberInput、
                switch;
    
    


