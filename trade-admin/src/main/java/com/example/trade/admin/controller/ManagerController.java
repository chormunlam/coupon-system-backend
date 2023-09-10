package com.example.trade.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {

    /**
     * 跳转到主页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 跳转券批次信息添加
     *
     * @return
     */
    @RequestMapping("/addCouponBatch")
    public String addGoods() {
        return "add_coupon_batch";//this is the page name
    }

}
