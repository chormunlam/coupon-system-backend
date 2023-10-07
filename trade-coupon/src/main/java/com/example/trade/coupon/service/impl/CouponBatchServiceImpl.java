package com.example.trade.coupon.service.impl;

import com.example.trade.coupon.db.dao.CouponBatchDao;
import com.example.trade.coupon.db.model.CouponBatch;
import com.example.trade.coupon.service.CouponBatchService;
import com.example.trade.coupon.utils.RedisWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponBatchServiceImpl implements CouponBatchService {

    @Autowired
    private CouponBatchDao couponBatchDao;

    @Autowired
    private RedisWorker redisWorker;

    @Override
    public boolean insertCouponBatch(CouponBatch couponBatch) {
        return couponBatchDao.insertCouponBatch(couponBatch);
    }

    @Override
    public List<CouponBatch> queryCouponBatchList() {
        return couponBatchDao.queryCouponBatchList();
    }

    @Override
    public CouponBatch queryCouponBatchById(long id){
        return couponBatchDao.queryCouponBatchById(id);
    }

    @Override
    public boolean pushBatchListRuleToCache() {
        List<CouponBatch> couponBatches = couponBatchDao.queryCouponBatchList();
        for (CouponBatch couponBatch : couponBatches) {
            redisWorker.setKey("couponBatchRule:" + couponBatch.getId(),
                    couponBatch.getRule());
        }
        return true;
    }

}
