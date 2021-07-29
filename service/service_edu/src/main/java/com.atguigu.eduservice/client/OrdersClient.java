package com.atguigu.eduservice.client;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/7/2614:11
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/7/26 14:11
 * @updateDate 2021/7/26 14:11
 **/
@Component
@FeignClient("service-order")
public interface OrdersClient {
    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("/eduorder/order/isBuyCourse/{courseId}/{memberId}")
    public boolean isBuyCourse(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);
}
