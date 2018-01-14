package com.wukp.boot.moudle.demo.service.impl;

import com.wukp.boot.moudle.demo.dao.CityDao;
import com.wukp.boot.moudle.demo.dao.DemoDao;
import com.wukp.boot.moudle.demo.orm.City;
import com.wukp.boot.moudle.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoDao demoDao;

    @Autowired
    private CityDao cityDao;


    @Autowired
    private RedisTemplate redisTemplate;


    public City findByName2(String name) {
        City city = cityDao.findByName(name);
        return city;
    }


    public City findByName(String name) {
        City city = demoDao.findByName(name);
        return city;
    }
//    /**
//     * 获取城市逻辑：
//     * 如果缓存存在，从缓存中获取城市信息
//     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
//     */
//    public City findByName(String name) {
//        // 从缓存中获取城市信息
//        String key = "city_" + name;
//        ValueOperations<String, City> operations = redisTemplate.opsForValue();
//
//        // 缓存存在
//        boolean hasKey = redisTemplate.hasKey(key);
//        if (hasKey) {
//            City city = operations.get(key);
//
//            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
//            return city;
//        }
//
//        // 从 DB 中获取城市信息
//        City city = demoDao.findByName(name);
//
//        // 插入缓存
//        operations.set(key, city, 10, TimeUnit.SECONDS);
//        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
//
//        return city;
//    }

}
