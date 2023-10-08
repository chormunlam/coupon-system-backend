package com.example.trade.coupon.controller;

import com.example.trade.coupon.mq.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Import the correct annotation
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class CouponController {
    @RequestMapping("/coupon/test")
    @ResponseBody
    public String hello(){
        return "hello world"; // Use double quotes for strings
    }

    @Autowired
    private MessageSender messageSender;

    @RequestMapping("/sendMessage/{message}")
    @ResponseBody
    public String sendMessage(@PathVariable("message") String message) {
        try {
            messageSender.sendMessage("test-topic", message);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return "发送消息:"+message;
    }
}
