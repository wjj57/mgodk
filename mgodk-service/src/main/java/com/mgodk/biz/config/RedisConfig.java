package com.mgodk.biz.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description Redis内存数据库配置
 * @Author WJJ
 * @Date 2020/09/07 15:00
 * @Version 1.0
 */
//@Configuration
public class RedisConfig {
    /**Redis 配置：spring-boot-starter-data-redis
     *  1、默认配置：LettuceConnectionFactory 为连接池工厂，lettuce 为客户端，JdkSerializationRedisSerializer 为序列化器
     *  2、连接池工厂有：JedisPoolConfig、RedisTemplate、RedisConnectionFactory(JredisConnectionFactory/JedisConnectionFactory/LettuceConnectionFactory/SrpConnectionFactory)
     *  3、Spring支持的序列化器有：
     *      StringRedisSerializer ：String类型序列化器；
     *      Jackson2JsonRedisSerializer ：JSON类型序列化器，时间稍长，序列化后长度最短；
     *      JdkSerializationRedisSerializer ：二进制字节码类型序列化器，时间高效，序列化后长度最长，是JDK原生的序列化器，支持对所有实现Serializable的类进行序列化；
     *      OxmSerializer ：xml类型序列化器；
     *      GenericToStringRedisSerializer、GenericJackson2JsonRedisSerializer；
     *  注：
     *      1、默认的连接池工厂可以自动注入，也可以在配置时参照默认配置把工厂直接当成参数使用
     *      2、Redis 支持事务，但RedisTemplate、StringRedisTemplate 默认没有开启事务，可以在自定义配置中开启
     *      3、使用@Resource 注入RedisTemplate<String,Object>测试时，存入的数据会出现乱码等问题
     *      4、存储格式设置，若不进行自定义配置，可以修改序列化器，如redisTemplate.setKeySerializer(RedisSerializer.string())，
     *          为了方便使用，编写Redis的配置类进行统一设置，自定义配置，然后使用@AutoWired注入
     * Redis 操作：
     *  1、开启事务管理，multi() 标记事务开始位置 ，exec() 标记事务结束位置；
     *  2、常用操作类型 StringRedisTemplate、RedisTemplate<String,Object>；
     *  3、StringRedisTemplate 满足一般的使用，操作只接受字符串类型数据，不关注其格式；
     *      而RedisTemplate 用于处理复杂性的数据结构，可以自定义序列化方式，返回数据处理比较麻烦不推荐使用；
     *  4、StringRedisTemplate 返回的集合对象类型数据，采用下面方式
     *      CollectionType c = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,SysUser.class)
     *  5、opsForValue()操作字符串、opsForHash()操作hash、opsForList()操作list、opsForSet()操作set、opsForZset()操作有序set
     */
//    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        return stringRedisSerializer;
    }
//    @Bean
    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        //指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //指定序列化输入的类型，类必须是非final修饰的，否则报错。
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonRedisSerializer.setObjectMapper(objectMapper);
        return jsonRedisSerializer;
    }

//    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        //关联 连接池工厂
        template.setConnectionFactory(redisConnectionFactory);
        //定义序列化方式
        template.setKeySerializer(stringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer());
        template.setHashKeySerializer(stringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer());
        //开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }

//    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        //关联 连接池工厂
        template.setConnectionFactory(redisConnectionFactory);
        //开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }

    /*@Bean
    public RedisTemplate<Object,Object> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        //关联 连接池工厂
        template.setConnectionFactory(redisConnectionFactory);
        //定义序列化方式
        template.setKeySerializer(jackson2JsonRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer());
        template.setHashKeySerializer(jackson2JsonRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer());
        //开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }*/
}
