package com.example.trade.coupon.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.Collections;

@Slf4j
@Service
public class RedisLockUtil {
    public static final String LOCK_SUCCESS = "OK"; // Constant for successful lock acquisition
    private static final Long RELEASE_SUCCESS = 1L; // Constant for successful lock release
    private static final int MAX_TRY_COUNT = 3; // Maximum number of lock acquisition attempts

    @Autowired
    private JedisPool jedisPool; // Autowired JedisPool for managing Redis connections



    /**
     * Attempt to acquire a lock.
     *
     * @param lockKey    Lock key
     * @param requestId  Request identifier
     * @param expireTime Expiration time in milliseconds
     * @return Whether the lock acquisition was successful
     */
    public boolean tryGetLock(String lockKey, String requestId, int expireTime) {
        try {
            Jedis jedisClient = jedisPool.getResource(); // Get a Redis connection from the pool

            // Try to set the lock key with specified options (NX = Set if Not eXists, PX = Set the expiration time in milliseconds)
            String result = jedisClient.set(lockKey, requestId, "NX", "PX", expireTime);

            int tryCount = 0;
            do {
                if (LOCK_SUCCESS.equals(result)) { // If the lock was acquired successfully
                    return true;
                }
                Thread.sleep(20); // Sleep briefly before retrying
                tryCount++;
                // When the first lock attempt fails, retry, but not more than the maximum number of times
            } while (tryCount < MAX_TRY_COUNT);
            log.error("tryLock error, lockKey: {}", lockKey);
        } catch (Exception e) {
            log.error("tryLock error, lockKey: {}", lockKey, e);
        }
        return false; // Return false if the lock was not acquired successfully
    }

    /**
     * Release the lock using a Lua script to ensure consistency.
     *
     * @param lockKey   Lock key
     * @param requestId Request identifier
     * @return Whether the lock release was successful
     */
    public boolean releaseLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Jedis jedis = jedisPool.getResource(); // Get a Redis connection from the pool

        // Execute Lua script to release the lock by checking if the current lock holder matches the request identifier
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) { // If the lock was released successfully
            return true;
        }
        return false; // Return false if the lock was not released successfully
    }
}
