package com.atguigu.aclservice.service.impl;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2510:25
 */

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @description zkjy
 * @author zkjy
 * @updateUser
 * @createDate 2021/6/25 10:25
 * @updateDate 2021/6/25 10:25     
 * @version 1.0
 **/
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
