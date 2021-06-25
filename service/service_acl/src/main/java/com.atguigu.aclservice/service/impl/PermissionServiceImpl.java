package com.atguigu.aclservice.service.impl;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2510:53
 */

import com.alibaba.fastjson.JSONObject;
import com.atguigu.aclservice.entity.Permission;
import com.atguigu.aclservice.entity.User;
import com.atguigu.aclservice.helper.MemuHelper;
import com.atguigu.aclservice.helper.PermissionHelper;
import com.atguigu.aclservice.mapper.PermissionMapper;
import com.atguigu.aclservice.service.PermissionService;
import com.atguigu.aclservice.service.RolePermissionService;
import com.atguigu.aclservice.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/25 10:53
 * @updateDate 2021/6/25 10:53
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private RolePermissionService rolePermissionService = null;

    @Autowired
    private UserService userService = null;

    //获取全部菜单
    @Override
    public List<Permission> queryAllMenu() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<Permission> permissions = baseMapper.selectList(wrapper);
        return permissions;
    }

    @Override
    public List<Permission> selectAllMenu(String roleId) {
        return null;
    }

    @Override
    public void saveRolePermissionRealtionShip(String roleId, String[] permissionId) {

    }

    @Override
    public void removeChildById(String id) {

    }

    @Override
    public List<String> selectPermissionValueByUserId(String id) {
        return null;
    }

    @Override
    public List<JSONObject> selectPermissionByUserId(String userId) {
        List<Permission> selectPermissionValueList = null;
        if (this.isSysAdmin(userId)) {
            //如果是超级管理员，获取所有菜单
            selectPermissionValueList = baseMapper.selectList(null);
        } else {
            selectPermissionValueList = baseMapper.selectPermissionByUserId(userId);
        }
        List<Permission> permissionList = PermissionHelper.bulid(selectPermissionValueList);
        List<JSONObject> result = MemuHelper.build(permissionList);
        return result;
    }

    @Override
    public List<Permission> queryAllMenuGuli() {
        return null;
    }

    @Override
    public void removeChildByIdGuli(String id) {

    }

    @Override
    public void saveRolePermissionRealtionShipGuli(String roleId, String[] permissionId) {

    }


    /**
     * @Description 判断用户是否系统管理员
     * @Author zkjy
     * @param: userId
     * @return:
     */
    private boolean isSysAdmin(String id) {
        User user = userService.getById(id);
        if (user != null && "admin".equals(user.getUsername())) {
            return true;
        }
        return false;
    }
}
