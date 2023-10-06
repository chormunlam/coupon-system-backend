package com.example.trade.user.controller;

import com.alibaba.fastjson.JSON;
import com.example.trade.coupon.db.model.Coupon;
import com.example.trade.coupon.db.model.CouponBatch;
import com.example.trade.coupon.db.model.CouponRule;
import com.example.trade.coupon.service.CouponBatchService;
import com.example.trade.coupon.service.CouponQueryService;

import com.example.trade.coupon.db.model.Coupon;
import com.example.trade.coupon.service.CouponQueryService;
import com.example.trade.coupon.utils.RedisWorker;
import com.example.trade.user.vo.CouponVO;
import lombok.extern.slf4j.Slf4j;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserCouponController {

    @Autowired
    private CouponQueryService couponQueryService;

    @Autowired
    private RedisWorker redisWorker;

    @Autowired
    private CouponBatchService couponBatchService;

    /**
     * 跳转到用户的优惠券列表页
     * @param userId
     * @return
     */
    @RequestMapping("/coupon/list/{userId}")
    public ModelAndView userCouponList(@PathVariable("userId") long userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coupon_list");
//        serch all useer coupon
        List<Coupon> coupons = couponQueryService.queryUsrCoupons(userId);
        //view object
        List<CouponVO> notUsedList = new ArrayList<>();
        List<CouponVO> usedList = new ArrayList<>();
        List<CouponVO> expiredList = new ArrayList<>();

        for (Coupon coupon : coupons) {
            CouponVO couponVo = createCouponVo(coupon);//tranfer method, and we need redis,
            if (coupon.getStatus() == 0) {
                notUsedList.add(couponVo);
            } else if (coupon.getStatus() == 1) {
                usedList.add(couponVo);
            } else if (coupon.getStatus() == 2) {
                expiredList.add(couponVo);
            }
        }
        modelAndView.addObject("notUsedList", notUsedList);
        modelAndView.addObject("usedList", usedList);
        modelAndView.addObject("expiredList", expiredList);
        return modelAndView;
    }

    public CouponVO createCouponVo(Coupon coupon) {
        CouponVO couponVO = new CouponVO();
        //serach the redis first, (get cache first),
        String batchRule = redisWorker.getValueByKey("couponBatchRule:" + coupon.getBatchId());
        if(StringUtils.isEmpty(batchRule)){
            CouponBatch couponBatch =couponBatchService.queryCouponBatchById(coupon.getBatchId());
            batchRule=couponBatch.getRule();
        }

        /*
         * 将JSON中的rule规则，转化成CouponRule对象
         */

        CouponRule couponRule = JSON.parseObject(batchRule, CouponRule.class);

        if (couponRule.getCouponType() == 1) {
            //满减 券
            couponVO.setThresholdAmountStr("满" + couponRule.getThresholdAmount() + "元可用");
        }

        couponVO.setDiscountAmount(couponRule.getDiscountAmount());
        Date startTime = couponRule.getStartTime();
        Date endTime = couponRule.getEndTime();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = dateFormat.format(startTime);
        String endTimeStr = dateFormat.format(endTime);
        couponVO.setStartTimeToEndTime(startTimeStr+"~"+endTimeStr);
        couponVO.setCouponName(coupon.getCouponName());
        return couponVO;
    }
}
