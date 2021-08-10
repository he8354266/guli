package com.atguigu.msmservice;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/216:48
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/2 16:48
 * @updateDate 2021/8/2 16:48
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.atguigu")
public class MsmApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsmApplication.class, args);
    }
}
