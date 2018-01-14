package com.wukp.boot;

import com.wukp.boot.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/caches")
public class CacheController {
 
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public String test() {
        redisUtils.set("123", "hello world");
        System.out.println("进入了方法");
        String string = redisUtils.get("123").toString();
        System.out.println("string=" + string);
        try {
            Thread.sleep(11 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        string = redisUtils.get("123").toString();
        System.out.println("string=" + string);
        return string;
    }

}