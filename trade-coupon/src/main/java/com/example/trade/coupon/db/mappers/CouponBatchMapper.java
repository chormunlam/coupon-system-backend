package com.example.trade.coupon.db.mappers;

import com.example.trade.coupon.db.model.CouponBatch;

import java.util.List;

public interface CouponBatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CouponBatch record);

    int insertSelective(CouponBatch record);

    CouponBatch selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponBatch record);

    int updateByPrimaryKey(CouponBatch record);

    List<CouponBatch> queryCouponBatchList();

    //add this
    int updateSendCouponBatchCount(Long id);

}