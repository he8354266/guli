package com.atguigu.msmservice.controller;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/109:14
 */

import com.atguigu.msmservice.service.MsmService;
import com.atguigu.commonutils.R;
import com.atguigu.msmservice.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/10 9:14
 * @updateDate 2021/8/10 9:14
 **/
@RestController
@RequestMapping("/edumsm/msm")
@CrossOrigin
public class MsmController {
    @Autowired
    private MsmService msmService = null;
    @Autowired
    private RedisTemplate<String, String> redisTemplate = null;

    //发送短信的方法
    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable("phone") String phone) {
        //1 从redis获取验证码，如果获取到直接返回
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            return R.ok();
        }
        //2 如果redis获取 不到，进行阿里云发送
        //生成随机值，传递阿里云进行发送
        code = RandomUtil.getFourBitRandom();
        Map<String, Object> param = new HashMap<>();
        param.put("code", code);
        //调用service发送短信的方法
        boolean isSend = msmService.send(param, phone);
        if (isSend) {
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return R.ok();
        }else {
            return R.error().message("短信发送失败");
        }
    }
}
