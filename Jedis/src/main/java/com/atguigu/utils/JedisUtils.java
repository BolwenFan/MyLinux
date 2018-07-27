package com.atguigu.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class JedisUtils {

    public static JedisPool jedisPool;

    static {
        jedisPool = new JedisPool(new GenericObjectPoolConfig(),"192.168.27.133",Protocol.DEFAULT_PORT,Protocol.DEFAULT_TIMEOUT,"123");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void releaseJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
