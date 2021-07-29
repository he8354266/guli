package com.atguigu.educms;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/7/214:09
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/7/2 14:09
 * @updateDate 2021/7/2 14:09
 **/
@SpringBootApplication
@ComponentScan({"com.atguigu"}) //指定扫描位置
@MapperScan(basePackages = "com.atguigu.educms.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
