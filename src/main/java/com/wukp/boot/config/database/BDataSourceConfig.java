package com.wukp.boot.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多个数据源配置 の 配置B
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = BDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "bSqlSessionFactory")
public class BDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.wukp.boot.moudle.demo.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${b.datasource.url}")
    private String url;

    @Value("${b.datasource.username}")
    private String user;

    @Value("${b.datasource.password}")
    private String password;

    @Value("${b.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "bDataSource")
    @Primary
    public DataSource bDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "bTransactionManager")
    @Primary
    public DataSourceTransactionManager bTransactionManager() {
        return new DataSourceTransactionManager(bDataSource());
    }

    @Bean(name = "bSqlSessionFactory")
    @Primary
    public SqlSessionFactory bSqlSessionFactory(@Qualifier("bDataSource") DataSource bDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(BDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}