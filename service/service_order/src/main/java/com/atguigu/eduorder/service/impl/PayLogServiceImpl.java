package com.atguigu.eduorder.service.impl;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1011:29
 */

import com.alibaba.fastjson.JSONObject;
import com.atguigu.eduorder.entity.Order;
import com.atguigu.eduorder.entity.PayLog;
import com.atguigu.eduorder.mapper.PayLogMapper;
import com.atguigu.eduorder.service.OrderService;
import com.atguigu.eduorder.service.PayLogService;
import com.atguigu.eduorder.utils.HttpClient;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/10 11:29
 * @updateDate 2021/8/10 11:29
 **/
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

    @Autowired
    private OrderService orderService = null;

    //生成微信支付二维码接口
    @Override
    public Map createNatvie(String orderNo) {
        //1 根据订单号查询订单信息
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        Order order = orderService.getOne(wrapper);

        //2 使用map设置生成二维码需要参数
        Map m = new HashMap();
        m.put("appid", "wx74862e0dfcf69954");
        m.put("mch_id", "1558950191");
        m.put("nonce_str", WXPayUtil.generateNonceStr());
        m.put("body", order.getCourseTitle()); //课程标题
        m.put("out_trade_no", orderNo); //订单号
        m.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue() + "");
        m.put("spbill_create_ip", "127.0.0.1");
        m.put("notify_url", "http://guli.shop/api/order/weixinPay/weixinNotify\n");
        m.put("trade_type", "NATIVE");

        //3 发送httpclient请求，传递参数xml格式，微信支付提供的固定的地址
        HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
        //设置xml格式的参数
        try {
            client.setXmlParam(WXPayUtil.generateSignedXml(m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            //执行post请求
            client.post();

            //4 得到发送请求返回结果
            //返回内容，是使用xml格式返回
            String xml = client.getContent();

            //把xml格式转换map集合，把map集合返回
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            //最终返回的数据 封装
            HashMap<String, Object> map = new HashMap<>();
            map.put("out_trade_no", orderNo);
            map.put("course_id", order.getCourseId());
            map.put("total_fee", order.getTotalFee());
            map.put("result_code", resultMap.get("result_code"));  //返回二维码操作状态码
            map.put("code_url", resultMap.get("code_url"));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuliException(20001, "生成二维码失败");
        }
    }

    //查询订单支付状态
    @Override
    public Map<String, String> queryPayStatus(String orderNo) {
        try {
            //1、封装参数
            Map m = new HashMap<>();
            m.put("appid", "wx74862e0dfcf69954");
            m.put("mch_id", "1558950191");
            m.put("out_trade_no", orderNo);
            m.put("nonce_str", WXPayUtil.generateNonceStr());

            //2 发送httpclient
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            client.post();
            //3 得到请求返回内容
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //添加支付记录和更新订单状态
    @Override
    public void updateOrdersStatus(Map<String, String> map) {
        String orderNo = map.get("out_trade_no");
        //根据订单号查询订单信息
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        Order order = orderService.getOne(wrapper);

        //更新订单表订单状态
        if (order.getStatus().intValue() == 1) {
            return;
        }
        order.setStatus(1);//1 代表已经支付
        orderService.updateById(order);

        //向支付宝表添加支付记录
        PayLog payLog = new PayLog();
        payLog.setOrderNo(orderNo);
        payLog.setOrderNo(orderNo);  //订单号
        payLog.setPayTime(new Date()); //订单完成时间
        payLog.setPayType(1);//支付类型 1微信


        payLog.setTotalFee(order.getTotalFee());//总金额(分)
        payLog.setTradeState(map.get("trade_state"));//支付状态
        payLog.setTransactionId(map.get("transaction_id")); //流水号
        payLog.setAttr(JSONObject.toJSONString(map));

        baseMapper.insert(payLog);

    }
}
