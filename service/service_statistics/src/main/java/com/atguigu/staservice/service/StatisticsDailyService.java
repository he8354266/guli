package com.atguigu.staservice.service;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1810:48
 */

import com.atguigu.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/18 10:48
 * @updateDate 2021/8/18 10:48
 **/
public interface StatisticsDailyService extends IService<StatisticsDaily> {
    void registerCount(String day);

    //图表显示，返回两部分数据，日期json数组，数量json数组
    Map<String, Object> getShowData(String type, String begin, String end);
}
