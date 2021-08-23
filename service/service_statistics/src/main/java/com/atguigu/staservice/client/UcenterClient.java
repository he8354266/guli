package com.atguigu.staservice.client;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/2310:29
 */

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/23 10:29
 * @updateDate 2021/8/23 10:29
 **/
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    //查询某一天注册人数
    @GetMapping("/educenter/member/countRegister/{day}")
    public R countRegister(@PathVariable("day") String day);
}
