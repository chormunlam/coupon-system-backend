package com.example.trade.coupon.controller;

import org.springframework.stereotype.Controller; // Import the correct annotation
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CouponController {
    @RequestMapping("/coupon/test")
    @ResponseBody
    public String hello(){
        return "hello world"; // Use double quotes for strings
    }
}
