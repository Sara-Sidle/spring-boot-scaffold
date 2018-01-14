package com.wukp.boot.moudle.demo.dao;

import com.wukp.boot.moudle.demo.orm.City;
import org.apache.ibatis.annotations.*;

/**
 * 城市 DAO 接口类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Mapper // 标志为 Mybatis 的 Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    @Select("SELECT id,type, name, value,timestrap,status FROM PM_PARAM where id=#{id}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "name", column = "name"),
            @Result(property = "value", column = "value"),
            @Result(property = "timestrap", column = "timestrap"),
            @Result(property = "status", column = "status")
    })
    City findByName(@Param("id") String cityName);
}
