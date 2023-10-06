package com.example.trade.coupon.db.dao.impl;

import com.example.trade.coupon.db.dao.CouponDao;
import com.example.trade.coupon.db.mappers.CouponMapper;
import com.example.trade.coupon.db.model.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 券-数据库操作
 */
@Slf4j
@Service
public class CouponDaoImpl implements CouponDao {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public boolean insertCoupon(Coupon coupon) {
        int result = couponMapper.insert(coupon);

        //let check the error message
//        int a=0;
//        int b=100/a;
        //大于0 表示插入成功
        return result > 0;
    }

    @Override
    public List<Coupon> queryUserCoupons(long userId) {
        return couponMapper.queryUserCoupons(userId);
    }
}