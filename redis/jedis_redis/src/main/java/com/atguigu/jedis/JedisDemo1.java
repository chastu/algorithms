package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.235.100",6379);
        //测试
        String value = jedis.ping();
        System.out.println(value);
    }
    @Test
    public void demo1(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.235.100",6379);
        //添加key
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        //得到所有key
        Set<String> keys = jedis.keys("*");
        //便利所有的key
        for (String key : keys) {
            System.out.println(key);
        }
    }
    @Test
    public void demo2(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.235.100",6379);
        //添加
        jedis.lpush("key1","lucy","mary","jack");
        //取值
        List<String> values = jedis.lrange("key1", 0, -1);
        //遍历输出
        for (String value : values) {
            System.out.println(value);
        }
    }
    @Test
    public void demo3(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.235.100",6379);
        //添加set集合
        jedis.sadd("name","lucy","jack");
        //取值
        Set<String> names = jedis.smembers("name");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
