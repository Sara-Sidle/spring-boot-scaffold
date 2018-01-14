package com.wukp.boot.moudle.demo.demodao;

import com.wukp.boot.moudle.demo.orm.City;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface DemoDao {


    /**
     * 根据城市 ID，获取城市信息
     *
     * @return
     */
    City findByName(@Param("id") String cityName);

}
