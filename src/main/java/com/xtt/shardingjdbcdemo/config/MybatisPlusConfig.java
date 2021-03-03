package com.xtt.shardingjdbcdemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MybatisPlusConfig
 * @Author Monster
 * @Date 2021/3/2 10:42
 * @Version 1.0
 */
@Configuration
@MapperScan("com.xtt.shardingjdbcdemo.dao")
public class MybatisPlusConfig {

    /**
     * 官网说PerformanceInterceptor在3.2.0 后的版本已被移除掉，如果想进行性能分析，用第三方的
     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        // SQL性能分析，线上不推荐，开发环境调优使用，最大执行时长
//        performanceInterceptor.setMaxTime(1000);
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
