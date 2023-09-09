package com.example.trade.coupon.db.dao.impl;

import com.example.trade.coupon.db.dao.CouponBatchDao;
import com.example.trade.coupon.db.mappers.CouponBatchMapper;
import com.example.trade.coupon.db.model.CouponBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * couponbatch db operation
 */

//dont forget to add the Service, ow spring wont run it.
@Service
public class CouponBatchDaoImpl implements CouponBatchDao {
    //2
    @Autowired
    private CouponBatchMapper couponBatchMapper;
    @Override
    public boolean insertCouponBatch(CouponBatch couponBatch) {//1
        //3 4:asign it to int insertRes
        int insertRes=couponBatchMapper.insert(couponBatch);
        return insertRes > 0; //java auto simple the if else statement

    }
}
