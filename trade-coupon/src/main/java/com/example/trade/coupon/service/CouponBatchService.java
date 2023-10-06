package com.example.trade.coupon.service;

import com.example.trade.coupon.db.model.CouponBatch;


import java.util.List;

public interface CouponBatchService {

    /**
     * 新增一个券批次
     *
     * @param couponBatch
     * @return
     */
    boolean insertCouponBatch(CouponBatch couponBatch);


    /**
     * 查询优惠券批次列表
     * @return
     */
    List<CouponBatch> queryCouponBatchList();


    /**
     * 根据ID查询对应的券批次
     *
     * @param id
     * @return
     */
    CouponBatch queryCouponBatchById(long id);
}
