package com.atguigu.eduservice.config;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2517:28
 */

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/25 17:28
 * @updateDate 2021/6/25 17:28
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("com.atguigu.eduservice.mapper")
public class MybatisPlusConfig {
    /**
     * @param
     * @return
     * @Description 逻辑删除插件
     * @Author zkjy
     */

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * @param
     * @return
     * @Description 分页插件
     * @Author zkjy
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
