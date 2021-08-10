package com.atguigu.eduservice.controller;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/7/2915:28
 */

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/7/29 15:28
 * @updateDate 2021/7/29 15:28
 **/
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService = null;
    //注入vodClient
    private VodClient vodClient = null;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节，删除对应阿里云视频
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        //根据小节id获取视频id，调用方法实现视频删除
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        //判断小节里面是否有视频id
        if (!StringUtils.isEmpty(videoSourceId)) {
            //根据视频id,远程调用实现视频删除
            R result = vodClient.removeAlyVideo(videoSourceId);
            if (result.getCode() == 20001) {
                throw new GuliException(20001, "删除视频失败,熔断器...");
            }
        }
        //删除小节
        videoService.removeById(id);
        return R.ok();
    }
}
