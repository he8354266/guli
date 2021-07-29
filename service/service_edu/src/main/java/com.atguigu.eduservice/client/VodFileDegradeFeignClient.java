package com.atguigu.eduservice.client;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/7/2614:28
 */

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/7/26 14:28
 * @updateDate 2021/7/26 14:28
 **/
@Component
public class VodFileDegradeFeignClient implements VodClient {

    //出错后执行
    @Override
    public R removeAlyVideo(String id) {
        return null;
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return null;
    }
}
