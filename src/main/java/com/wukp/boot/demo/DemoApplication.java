package com.wukp.boot.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //移除自动注入数据源
@RestController  // 添加了一个注解
//@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public JedisPool jedisPool(@Value("${spring.redis.host}") String host,
                               @Value("${spring.redis.port}") int port,
                               @Value("${go.wy}") String wukp
    ) {
        System.out.println("配置redis参数" + host + " port:" + wukp);
        return new JedisPool(host, port);
    }

//    @Bean(initMethod="init",destroyMethod="close")
//    @ConfigurationProperties(prefix="dataSource")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }

    /**
     * @return
     */
    @Bean
    public DispatcherServlet dispatcherServlet() {
        System.out.println("声明dispatcherServlet");
        return new DispatcherServlet();
    }

    /**
     * 过滤器配置
     *
     * @return
     */
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        System.out.println("过滤器配置");
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    /**
     * 设置自定义过滤器
     */
//    @Bean
//    public FilterRegistrationBean appFilter() {
//        FilterRegistrationBean reg = new FilterRegistrationBean();
//        reg.setFilter(new LoggingFilter());
//        reg.addUrlPatterns("/api/*");
//        return reg;
//    }

    /**
     * 声明servlet映射
     *
     * @return
     */
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings("/druid/*");
//        return reg;
//    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    @RequestMapping("/")
    public String index() {
        return "Index Page";
    }

    //添加了一个方法
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("wukp");
        return "no hello world euwo goo22gle";

    }


    @RequestMapping("/methodPath")
    public String method() {
        return "mapping url is /classPath/methodPath";
    }

    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Login Page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "Login Post Request";
    }
}
