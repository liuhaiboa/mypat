package com.haibo.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean()
    public MapperScannerConfigurer mapperScannerConfigurer(){
      MapperScannerConfigurer mapper=new MapperScannerConfigurer();
        mapper.setBasePackage("com.haibo.mapper");
        mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapper;

    }



}
