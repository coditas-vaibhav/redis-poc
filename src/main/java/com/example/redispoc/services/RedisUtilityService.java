package com.example.redispoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtilityService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public void saveToRedis(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void deleteFromRedis(String key){
        redisTemplate.delete(key);
    }

    public String getFromRedis(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
