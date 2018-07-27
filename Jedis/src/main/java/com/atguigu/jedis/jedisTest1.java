package com.atguigu.jedis;


import redis.clients.jedis.Jedis;

// 使用普通方式连接linux的redis
public class jedisTest1 {

    public static void main(String[] args) {
        //指定Redis服务器的IP地址和端口号
        Jedis jedis = new Jedis("192.168.27.133", 6379);
        //设置密码
        jedis.auth("123");
        //执行ping命令
        String ping = jedis.ping();
        System.out.println(ping);
        jedis.close();
        
    }
}
