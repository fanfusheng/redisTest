package com.atguigu.redis;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class RedisUtil {
    /**
     * It's for single redis
     */

    private static JedisPool jedisPool=null;

    public static Jedis getJedisFromPool(){
        if(jedisPool==null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(2); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            jedisPool=new JedisPool(jedisPoolConfig,"192.168.64.102", 6379  );

            return jedisPool.getResource();
        }else{
            return jedisPool.getResource();
        }
    }

    /**
     * It's used for redisCluster
     */
    private static JedisCluster jedisCluster=null;

    public static JedisCluster getJedisclusterFromPool(){
        if(jedisCluster==null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(2); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            Set<HostAndPort> hostAndPortSet=new HashSet<>();
            hostAndPortSet.add(new HostAndPort("hadoop102",6379));
            hostAndPortSet.add(new HostAndPort("hadoop103",6379));
            hostAndPortSet.add(new HostAndPort("hadoop104",6379));

            JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, jedisPoolConfig);

            return jedisCluster;
        }else{
            return jedisCluster;
        }
    }
    /**
     * It's used for sentinel model.
     */
    private static Jedis jedisSentinel=null;

    public static Jedis getJedisSentinelFromPool(){
        if(jedisSentinel==null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(2); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            Set<String> sentinels=new HashSet<>();
            sentinels.add("hadoop102:6380");
            sentinels.add("hadoop103:6380");  //哨兵host和port
                                                                            //注意：masterName：必须写别名
            final JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig);
            return jedisSentinelPool.getResource();
        }else{
            return jedisSentinel;
        }
    }

}
