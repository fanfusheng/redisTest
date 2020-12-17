package com.atguigu.redis;

import redis.clients.jedis.JedisCluster;

public class TestCluster {
    public static void main(String[] args) {
        //todo 集群模式获取的的 jediscluter不能关闭
        final JedisCluster jediscluster = RedisUtil.getJedisclusterFromPool();
        jediscluster.set("k1", "v1");
        System.out.println(jediscluster.get("k1"));
    }
}