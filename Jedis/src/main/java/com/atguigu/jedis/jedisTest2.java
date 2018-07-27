package com.atguigu.jedis;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

// 使用JedisPool池的方式连接linux的redis
public class jedisTest2 {

    public static void main(String[] args) {

            GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

            JedisPool jedisPool = new JedisPool(genericObjectPoolConfig,"192.168.27.133",Protocol.DEFAULT_PORT,
                    Protocol.DEFAULT_TIMEOUT,"123");

            Jedis jedis = jedisPool.getResource();

            String ping = jedis.ping();

            System.out.println(ping);

            jedis.close();

            jedisPool.close();

        }
}
