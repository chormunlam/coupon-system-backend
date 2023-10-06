package com.example.trade.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example"}) //??
@MapperScan({"com.example.trade.coupon.db.mappers"})//tell where is the mapper is

@SpringBootApplication
public class TradeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeUserApplication.class, args);
    }

}
