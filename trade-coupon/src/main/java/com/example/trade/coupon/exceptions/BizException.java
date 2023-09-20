package com.example.trade.coupon.exceptions;

/**
 * 自定义业务异常
 */
public class BizException extends RuntimeException {

    public BizException(String str) {
        super(str);
    }

}