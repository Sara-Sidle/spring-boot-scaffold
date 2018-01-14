package com.wukp.boot;

import com.wukp.boot.property.HomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;

/**
 * 该启动类建议存放到跟路径下，这样测试类可以正常测试。
 */
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //移除自动注入数据源
@RestController  // 添加了一个注解
@SpringBootApplication
//@MapperScan("com.wukp.boot.moudle.*.dao")//加载数据库dao
public class StartApplication {

    @Autowired
    private HomeProperties homeProperties;

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(StartApplication.class, args);
    }

    /**
     * redis config start
     *
     * @param host redis ip地址
     * @param port 端口号
     * @param wukp 测试
     * @return 缓冲池
     */
    @Bean
    public JedisPool jedisPool(@Value("${spring.redis.host}") String host,
                               @Value("${spring.redis.port}") int port,
                               @Value("${go.wy}") String wukp
    ) {
        System.out.println("配置redis参数" + host + " port:" + port + ";test:" + wukp);
        return new JedisPool(host, port);
    }

//    @Bean(initMethod="init",destroyMethod="close")
//    @ConfigurationProperties(prefix="dataSource")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }

    /**
     * web servlet 声明
     *
     * @return
     */
    @Bean
    public DispatcherServlet dispatcherServlet() {
        System.out.println("声明 dispatcherServlet");
        System.out.println("\n" + homeProperties.toString());
        System.out.println();
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


    /**
     * 命令行
     *
     * @param ctx
     * @return
     */
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


}
