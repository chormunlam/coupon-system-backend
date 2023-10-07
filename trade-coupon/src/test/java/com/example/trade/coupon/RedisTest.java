package com.example.trade.coupon;


import com.example.trade.coupon.utils.RedisLockUtil;
import com.example.trade.coupon.utils.RedisWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisWorker redisWorker;

    @Autowired
    private RedisLockUtil redisLock;

    @Test
    public void setRedis(){
        redisWorker.setValue("product note","this cat food is super expensive but up to you buy or not");

    }
    @Test
    public void getRedis(){
        String name = redisWorker.getValueByKey("product note");
        System.out.println(name);
    }
    @Test
    public void redisLockTest() {
        String request1Id = UUID.randomUUID().toString();
        boolean result1 = redisLock.tryGetLock("redisLock1", request1Id, 500);
        System.out.println("  boolean result1 =" + result1);
        redisLock.releaseLock("redisLock1",request1Id);

        String request2Id = UUID.randomUUID().toString();
        boolean result2 = redisLock.tryGetLock("redisLock1", request2Id, 1000*2);
        System.out.println("  boolean result2 =" + result2);
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