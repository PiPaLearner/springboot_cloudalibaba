package com.personal.content_center.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspectConfig {

    @Pointcut(value = "execution(* com.personal.content_center.service.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void doBefore(DataSource dataSource){
        log.info("选择数据源---"+dataSource.toString());
        DataSourceContextHolder.setDataSource(dataSource.value().getValue());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}
