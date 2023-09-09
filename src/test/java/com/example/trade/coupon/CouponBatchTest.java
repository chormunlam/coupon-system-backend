package com.example.trade.coupon;

import com.alibaba.fastjson.JSON;
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
        couponBatch.setBatchName("909 coupon batch");
        couponBatch.setCouponName("1 dolloar off for 10$ spent");
        couponBatch.setCouponType(1);
        couponBatch.setRule("{}");
        couponBatch.setTotalCount(10L);
        couponBatch.setAvailableCount(10L);
        couponBatch.setUsedCount(2L);
        couponBatch.setAssignCount(1L);
        couponBatch.setGrantType(1);
        couponBatch.setCreateTime(new Date());
        couponBatch.setStatus(1);

        //4 insert
        boolean insertResult = couponBatchDao.insertCouponBatch(couponBatch);
        System.out.println(insertResult);
    }

    @Test
    public void CouponBatchDeleteTest() {
        boolean deleteResult = couponBatchDao.deleteCouponBatchById(7);
        System.out.println(deleteResult);
    }

    @Test
    public void CouponBatchQueryTest() {
        CouponBatch goods = couponBatchDao.queryCouponBatchById(7);
        System.out.println(JSON.toJSONString(goods));
    }

    @Test
    public void CouponBatchUpdateTest() {
        CouponBatch couponBatch = couponBatchDao.queryCouponBatchById(7);
        couponBatch.setBatchName(couponBatch.getBatchName() + "tesing update");
        couponBatchDao.updateCouponBatch(couponBatch);
    }
}
