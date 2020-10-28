package com.mgodk.test;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RedisTest
 * @Description Redis 使用
 * @Author WJJ
 * @Date 2020/10/28 09:46
 * @Version 1.0
 */
public class RedisTest {
    @Test
    public void test() throws Exception {
//        testJedis();
        testJedisPool();
        testJedisPoolShard();
    }

    public void testJedis() {
        //构造对象
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //添加数据
        jedis.set("first","123");
        //获取数据
        String str = jedis.get("first");
        System.out.println(str);
        //关闭连接
        jedis.close();
    }

    public void testJedisPool() {
        //构建连接池信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(10);
        //构建连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //获取数据
        System.out.println(jedis.get("first"));
        //释放连接
        jedisPool.returnResource(jedis);
        //关闭连接池
        jedisPool.close();
    }

    public void testJedisPoolShard() {
        //构建连接池信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(10);

        //定义集群信息
        List<JedisShardInfo> shardInfos = new ArrayList<>();
        shardInfos.add(new JedisShardInfo("127.0.0.1",6379));

        //构建集群连接池
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,shardInfos);
        //连接池获取 Jedis 分片对象
        ShardedJedis shardedJedis = shardedJedisPool.getResource();

        //获取数据
        System.out.println(shardedJedis.get("first"));

        //关闭，检测连接是否有效，有效放回，无效重置
        if (null != shardedJedis) {
            shardedJedis.close();
        }
        //关闭连接池
        shardedJedisPool.close();
    }

}
