package com.atguigu.oss.service;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/8/1215:57
 */

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/8/12 15:57
 * @updateDate 2021/8/12 15:57
 **/
public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
