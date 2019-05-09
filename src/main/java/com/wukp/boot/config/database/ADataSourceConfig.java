package com.wukp.boot.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import groovy.util.logging.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多个数据源配置 の 配置A
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ADataSourceConfig.PACKAGE, sqlSessionFactoryRef = "aSqlSessionFactory")
@Slf4j
public class ADataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.wukp.boot.moudle.demo.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${a.datasource.url}")
    private String url;

    @Value("${a.datasource.username}")
    private String user;

    @Value("${a.datasource.password}")
    private String password;

    @Value("${a.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "aDataSource")
    public DataSource aDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "aTransactionManager")
    public DataSourceTransactionManager aTransactionManager() {
        return new DataSourceTransactionManager(aDataSource());
    }

    @Bean(name = "aSqlSessionFactory")
    public SqlSessionFactory aSqlSessionFactory(@Qualifier("aDataSource") DataSource aDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(aDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ADataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}