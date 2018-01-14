package com.wukp.boot.moudle.demo.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;


/**
 * 城市实体类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = -1L;
    /**
     * 城市编号
     */
    private String id;
    private String type;
    private String name;
    private String value;
    private String timestrap;
    private String status;


    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", timestrap='" + timestrap + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
