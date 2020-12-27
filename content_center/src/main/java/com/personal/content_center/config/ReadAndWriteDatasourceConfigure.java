/**
 * copywrite 2015-2020 智慧享联
 * 不能修改和删除上面的版权声明
 * 此代码属于数据与信息中心部门编写，在未经允许的情况下不得传播复制
 * ReadAndWriteDatasourceConfigure.java
 * @Date 2017年7月7日 下午4:08:48
 * guguihe
 */
package com.personal.content_center.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/*
*
 * TODO:读库与写库数据源配置
 * 
 * @author leo
 * @Date 2020年12月27日
 */
@Configuration
public class ReadAndWriteDatasourceConfigure {

    private final Logger logger = LoggerFactory.getLogger(ReadAndWriteDatasourceConfigure.class);

    @Value("${spring.datasource.write.url}")
    private String writeUrl;
    @Value("${spring.datasource.write.username}")
    private String writeUser;
    @Value("${spring.datasource.write.password}")
    private String writePassword;
    @Value("${spring.datasource.write.driver-class-name}")
    private String writeDriverClass;

    @Value("${spring.datasource.write.type}")
    private String writeType;
    @Value("${spring.datasource.read.url}")
    private String readUrl;
    @Value("${spring.datasource.read.username}")
    private String readUser;
    @Value("${spring.datasource.read.password}")
    private String readPassword;
    @Value("${spring.datasource.read.driver-class-name}")
    private String readDriverClass;

    @Value("${spring.datasource.idleTimeout}")
    int idleTimeout;
    @Value("${spring.datasource.maximumPoolSize}")
    int maximumPoolSize;
    @Value("${spring.datasource.minIdle}")
    int minIdle;
    @Value("${spring.datasource.connectionTimeout}")
    int connectionTimeout;
    @Value("${spring.datasource.maxLifetime}")
    long maxLifetime;

    /**
     * TODO: 写库数据源，使用spring.datasource.write配置项
     * 
     * @return
     */
    @Primary
    @Bean(name = "writeDataSource")
    @Qualifier("writeDataSource")
    public DataSource writeDataSource() {
        HikariConfig hc = new HikariConfig();
        hc.setConnectionTestQuery("select 1");
        hc.setConnectionTimeout(connectionTimeout);
        hc.setDriverClassName(writeDriverClass);
        hc.setJdbcUrl(writeUrl);
        hc.setUsername(writeUser);
        hc.setPoolName("sip_write_datasource");
        hc.setPassword(writePassword);
        hc.setIdleTimeout(idleTimeout);
        hc.setMinimumIdle(minIdle);
        hc.setMaxLifetime(maxLifetime);
        hc.setMaximumPoolSize(maximumPoolSize);
        return new HikariDataSource(hc);
    }

    /**
     * TODO: 读库数据源，使用spring.datasource.read配置项
     * 
     * @return
     */
    @Bean(name = "readDataSource")
    @Qualifier("readDataSource")
    public DataSource readDataSource() {
        HikariConfig hc = new HikariConfig();
        hc.setConnectionTestQuery("select 1");
        hc.setDriverClassName(readDriverClass);
        hc.setIdleTimeout(idleTimeout);
        hc.setJdbcUrl(readUrl);
        hc.setUsername(readUser);
        hc.setPoolName("sip_read_datasource");
        hc.setPassword(readPassword);
        hc.setConnectionTimeout(connectionTimeout);
        hc.setMinimumIdle(minIdle);
        hc.setMaxLifetime(maxLifetime);
        hc.setMaximumPoolSize(maximumPoolSize);
        return new HikariDataSource(hc);
    }

    @Bean(name = "writeJdbcTemplate")
    public JdbcTemplate writeJdbcTemplate(@Qualifier("writeDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "readJdbcTemplate")
    public JdbcTemplate readJdbcTemplate(@Qualifier("readDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
