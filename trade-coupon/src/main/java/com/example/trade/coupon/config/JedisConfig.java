package com.example.trade.coupon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);

    // Redis server address
    private final String host = "localhost";//later will be cloud ip addr

    // Redis server connection port
    private final int port = 6379;

    // Connection timeout in milliseconds. The longest wait time to establish a connection. Negative value means wait indefinitely.
    private final int timeout = 5000;

    // Max number of connections in the connection pool (negative value means no limit)
    private final int maxActive = 8;

    // Max number of idle connections in the connection pool
    private final int maxIdle = 8;

    // Min number of idle connections in the connection pool
    private final int minIdle = 0;

    // Max wait time in the connection pool for blocking (negative value means no limit)
    private final long maxWaitMillis = -1;


    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);

        logger.info("JedisPool go go go sucuessful！");
        logger.info("redis addr：" + host + ":" + port);
        return jedisPool;
    }
}