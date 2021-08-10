package com.atguigu.msmservice.service;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/217:11
 */

import java.util.Map;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/2 17:11
 * @updateDate 2021/8/2 17:11
 **/
public interface MsmService {
    //发送短信
    boolean send(Map<String, Object> param, String phone);
}
