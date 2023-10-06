package com.example.trade.coupon.db.mappers;

import com.example.trade.coupon.db.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    List<Coupon> queryUserCoupons(Long userId);


}