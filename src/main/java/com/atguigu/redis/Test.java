package com.atguigu.redis;


import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        final Jedis jedis = RedisUtil.getJedisFromPool();
        //todo String
//        jedis.mset("1001","zhangsan");
//        jedis.mset("1002","lisi");
//        jedis.mset("1003","wangwu");
//        System.out.println(jedis.get("1001")+"\t"+jedis.get("1002")+"\t"+jedis.get("1003"));
        //todo List
//        jedis.lpush("name","zhangsan","lisi","wanger","mazi");
//        while (jedis.exists("name")) {
//            System.out.println(jedis.lpop("name"));
//        }
        //todo Set
//
////        jedis.sadd("user_id_1002","lisi","43","男","shanghai");
////        jedis.sadd("user_id_1003","wangwu","18","男","nanjing");
////        jedis.sadd("user_id_1004","huliu","32","女","California");
//      // String s = jedis.get("user_id_1001");
//        System.out.println(jedis.smembers("user_id_1001"));
//        //System.out.println(s);
        //todo Hash
//        final Map<String, String> map =new HashMap<>();
//        map.put("name","zhangsan");
//        map.put("age","24");
//        jedis.hset("stu_info",map);

        jedis.close();
    }
}
