package com.example.trade.coupon.db.dao.impl;

import com.example.trade.coupon.db.dao.CouponBatchDao;
import com.example.trade.coupon.db.mappers.CouponBatchMapper;
import com.example.trade.coupon.db.model.CouponBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean deleteCouponBatchById(long id){
        int result =couponBatchMapper.deleteByPrimaryKey(id);
        return result >0;

    }

    @Override
    public CouponBatch queryCouponBatchById(long id){
        return couponBatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateCouponBatch(CouponBatch couponBatch){
        int result=couponBatchMapper.updateByPrimaryKey(couponBatch);
        return result>0;
    }

    @Override
    public List<CouponBatch> queryCouponBatchList(){
        return couponBatchMapper.queryCouponBatchList();
    }



}
