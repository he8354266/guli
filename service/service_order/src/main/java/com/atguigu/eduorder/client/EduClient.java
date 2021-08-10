package com.atguigu.eduorder.client;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1010:41
 */

import com.atguigu.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/10 10:41
 * @updateDate 2021/8/10 10:41
 **/
@Component
@FeignClient("service-edu")
public interface EduClient {
    //根据课程id查询课程信息
    @PostMapping("/eduservice/coursefront/getCourseInfoOrder/{id}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);
}
