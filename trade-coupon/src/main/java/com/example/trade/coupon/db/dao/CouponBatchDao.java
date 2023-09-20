package com.example.trade.coupon.db.dao;

import com.example.trade.coupon.db.model.CouponBatch;

import java.util.List;

public interface CouponBatchDao {
    /**
     * add couponBatch
     * @param couponBatch
     * @return
     */
    boolean insertCouponBatch(CouponBatch couponBatch );

    /**
     * for delete
     * @param id
     * @return
     */
    boolean deleteCouponBatchById(long id);

    /**
     * select/read
     * @param id
     * @return
     */
    CouponBatch queryCouponBatchById(long id);

    /**
     * update
     * @param couponBatch
     * @return
     */

    boolean updateCouponBatch(CouponBatch couponBatch);

    /**
     * list of coupon batch
     * @return
     */
    List<CouponBatch> queryCouponBatchList();

    boolean updateSendCouponBatchCount(Long id);
}
