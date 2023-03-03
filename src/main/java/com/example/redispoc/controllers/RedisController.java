package com.example.redispoc.controllers;

import com.example.redispoc.dtos.Payload;
import com.example.redispoc.services.RedisUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtilityService redisUtilityService;

    @PostMapping("/add")
    public String addToKey(@RequestBody Payload payload){
        redisUtilityService.saveToRedis(payload.getKey(), payload.getValue());
        return "success";
    }

    @GetMapping("/find")
    public String getValue(@RequestParam("key") String key){
        return redisUtilityService.getFromRedis(key);
    }

    @GetMapping("/delete")
    public void deleteValue(@RequestParam("key") String key){
       redisUtilityService.deleteFromRedis(key);
    }
}
