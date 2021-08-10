package com.atguigu.eduorder.service;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1010:24
 */

import com.atguigu.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @description zkjy
 * @author zkjy
 * @updateUser
 * @createDate 2021/8/10 10:24
 * @updateDate 2021/8/10 10:24     
 * @version 1.0
 **/
public interface PayLogService extends IService<PayLog> {
    //生成微信支付二维码接口
    Map createNatvie(String orderNo);

    //根据订单号查询订单支付状态
    Map<String, String> queryPayStatus(String orderNo);

    //向支付表添加记录，更新订单状态
    void updateOrdersStatus(Map<String, String> map);
}
