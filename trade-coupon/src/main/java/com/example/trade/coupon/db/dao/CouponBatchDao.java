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
     * 查询优惠券批次列表
     * @return
     */
    List<CouponBatch> queryCouponBatchList();

    /**
     * 更新发券后券批次数量记录信息
     * @param id
     * @return
     */
    boolean updateSendCouponBatchCount(Long id);
}
