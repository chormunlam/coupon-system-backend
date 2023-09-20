package com.example.trade.coupon;

import com.example.trade.coupon.service.CouponSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponSendTest {
    @Autowired
    private CouponSendService couponSendService;
//let say we send coupon to userid 86869L
    @Test
    public void sendCouponTest() {
        couponSendService.sendUserCouponSyn(8, 86869L);
    }
}