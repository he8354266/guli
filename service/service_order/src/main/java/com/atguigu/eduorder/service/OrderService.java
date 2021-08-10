package com.atguigu.eduorder.service;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1010:22
 */

import com.atguigu.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/10 10:22
 * @updateDate 2021/8/10 10:22
 **/
public interface OrderService extends IService<Order> {
    //1 生成订单的方法
    String createOrders(String courseId, String memberIdByJwtToken);
}
