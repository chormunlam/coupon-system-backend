package com.example.trade.coupon;


import com.example.trade.coupon.utils.RedisWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisWorker redisWorker;

    @Test
    public void setRedis(){
        redisWorker.setValue("product note","this cat food is super expensive but up to you buy or not");

    }
    @Test
    public void getRedis(){
        String name = redisWorker.getValueByKey("product note");
        System.out.println(name);
    }
}
//    @Test
//    public void setRedis(){
//        redisWorker.setValue("product note","this cat food is super expensive but up to you buy or not");
//
//    }
//    @Test
//    public void getRedis(){
//        String name = redisWorker.getValueByKey("product note");
//        System.out.println(name);
//    }