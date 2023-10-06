package com.example.trade.coupon.service.impl;

import com.example.trade.coupon.db.dao.CouponDao;
import com.example.trade.coupon.db.model.Coupon;
import com.example.trade.coupon.service.CouponQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponQueryServiceImpl implements CouponQueryService {
    @Autowired
    private CouponDao couponDao;

    @Override
    public List<Coupon> queryUsrCoupons(long userId) {
        return couponDao.queryUserCoupons(userId);
    }
}