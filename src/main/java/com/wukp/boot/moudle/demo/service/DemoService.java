package com.wukp.boot.moudle.demo.service;

import com.wukp.boot.moudle.demo.orm.City;

/**
 * 城市业务逻辑接口类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
public interface DemoService {

    City findByName(String name);

    City findByName2(String name);

}
