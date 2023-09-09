package com.example.trade.coupon;

import com.example.trade.coupon.db.dao.CouponBatchDao;
import com.example.trade.coupon.db.model.CouponBatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//for Date
import java.util.Date;
//1 add these
@RunWith(SpringRunner.class)//for spring support
@SpringBootTest //for spring boot

public class CouponBatchTest {
    //3 dont forget autowired to import it
    @Autowired
    private CouponBatchDao couponBatchDao;

    //2 must add @test
    @Test
    public void CouponBatchInsertTest(){
        CouponBatch couponBatch = new CouponBatch();
        couponBatch.setBatchName("Fall School Open Coupon batch test ");
        couponBatch.setCouponName("Spent 100$ get 20$ off Coupon");
        couponBatch.setCouponType(1);
        couponBatch.setRule("{}");
        couponBatch.setTotalCount(100L);
        couponBatch.setAvailableCount(100L);
        couponBatch.setUsedCount(20L);
        couponBatch.setAssignCount(10L);
        couponBatch.setGrantType(1);
        couponBatch.setCreateTime(new Date());
        couponBatch.setStatus(1);

        //4 insert
        boolean insertResult = couponBatchDao.insertCouponBatch(couponBatch);
        System.out.println(insertResult);



    }
}
