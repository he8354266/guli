package com.atguigu.aclservice;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2416:22
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description zkjy
 * @author zkjy
 * @updateUser
 * @createDate 2021/6/24 16:22
 * @updateDate 2021/6/24 16:22     
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.atguigu")
@MapperScan(basePackages = "com.atguigu.aclservice.mapper")
public class ServiceAclApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }
}
