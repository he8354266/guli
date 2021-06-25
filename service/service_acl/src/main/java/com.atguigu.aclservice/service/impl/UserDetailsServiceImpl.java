package com.atguigu.aclservice.service.impl;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2510:25
 */

import com.atguigu.aclservice.entity.User;
import com.atguigu.aclservice.service.PermissionService;
import com.atguigu.aclservice.service.UserService;
import com.atguigu.serurity.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/25 10:25
 * @updateDate 2021/6/25 10:25
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService = null;
    @Autowired
    private PermissionService permissionService = null;

    /**
     * @Description 根据账号获取用户信息
     * @Author zkjy
     * @Param:
     * @returns: UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库取出用户信息
        User user = userService.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！请核实！");
        }
        // 返回UserDetails实现类
        com.atguigu.serurity.entity.User cuser = new com.atguigu.serurity.entity.User();
        BeanUtils.copyProperties(user, cuser);


        List<String> authorities = permissionService.selectPermissionValueByUserId(user.getId());
        SecurityUser securityUser = new SecurityUser(cuser);
        securityUser.setPermissionValueList(authorities);
        return securityUser;
    }
}
