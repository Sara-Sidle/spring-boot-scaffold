package com.wukp.boot.moudle.demo.controller;

import com.wukp.boot.config.MessageConfiguration;
import com.wukp.boot.moudle.demo.orm.City;
import com.wukp.boot.moudle.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 页面处理 Controller类
 */
@RestController
public class DemoRESTController {

    @Autowired
    private DemoService demoService;

    /**
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Index Page";
    }

    @RequestMapping(value = "/api/city")
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        System.out.println(cityName);
        City city = demoService.findByName("sm_zhusao_param_cs");
        return city;
    }

    @RequestMapping(value = "/api/city2")
    public City findCity(@RequestParam(value = "cityName", required = true) String cityName) {
        System.out.println(cityName);
        City city = demoService.findByName2("sm_zhusao_param_cs");
        System.out.println(city.toString());
        return city;
    }



    /**
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("wukp");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);

        if (ctx.getBean("message") instanceof String){
            System.out.println((String)ctx.getBean("message") );
            System.out.println((String)ctx.getBean("message4gou") );
        }
        return "no hello world euwo goo22gle";

    }

    /**
     * @return
     */
    @RequestMapping("/methodPath")
    public String method() {
        return "mapping url is /classPath/methodPath";
    }

    /**
     * @param username
     * @return
     */
    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Login Page";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "Login Post Request";
    }
}