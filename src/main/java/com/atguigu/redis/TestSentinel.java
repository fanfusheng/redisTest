package com.atguigu.redis;

import redis.clients.jedis.Jedis;

public class TestSentinel {
    public static void main(String[] args) {
        final Jedis jedis = RedisUtil.getJedisSentinelFromPool();
        jedis.set("k100","v100");
        System.out.println(jedis.get("k100"));

        jedis.close();
    }
}
