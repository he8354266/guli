package com.atguigu.staservice;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/189:45
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/18 9:45
 * @updateDate 2021/8/18 9:45
 **/
@SpringBootApplication
//@ComponentScan(basePackages = {"com.atguigu"})
//@EnableDiscoveryClient
//@EnableFeignClients
//@MapperScan("com.atguigu.staservice.mapper")
//@EnableScheduling
public class StaApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication.class, args);
    }
}
