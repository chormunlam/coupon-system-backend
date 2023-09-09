package com.example.trade.coupon.db.dao;

import com.example.trade.coupon.db.model.CouponBatch;

public interface CouponBatchDao {
    /**
     * add couponBatch
     * @param couponBatch
     * @return
     */
    boolean insertCouponBatch(CouponBatch couponBatch );
}
