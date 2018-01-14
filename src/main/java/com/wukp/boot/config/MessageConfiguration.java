package com.wukp.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置设置，这个待查
 * Created by bysocket on 08/09/2017.
 */
@Configuration
public class MessageConfiguration {

    @Bean
    public String message() {
        return "message configuration";
    }

    @Bean
    public String message4gou() {
        return "go go go";
    }
}
