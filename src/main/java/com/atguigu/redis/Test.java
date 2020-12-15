package com.atguigu.redis;


import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        final Jedis jedis = new Jedis("hadoop102", 6379);
        final String ping = jedis.ping();
        if(ping=="pong"){
            System.out.println("connect !");
        }
        jedis.close();
    }
}
