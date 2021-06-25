package com.atguigu.aclservice.service.impl;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2510:19
 */

import com.atguigu.aclservice.entity.UserRole;
import com.atguigu.aclservice.mapper.UserRoleMapper;
import com.atguigu.aclservice.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/25 10:19
 * @updateDate 2021/6/25 10:19
 **/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {
}
