package com.atguigu.aclservice.config;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2517:28
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/25 17:28
 * @updateDate 2021/6/25 17:28
 **/
@Configuration
public class MybatisPlusConfig {
    
    /**
     * @Description 分页插件
     * @Author  zkjy
     * @param
     * @return  
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
