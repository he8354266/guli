package com.atguigu.aclservice.controller;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/3013:57
 */

import com.atguigu.aclservice.entity.Role;
import com.atguigu.aclservice.service.RoleService;
import com.atguigu.commonutils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/30 13:57
 * @updateDate 2021/6/30 13:57
 **/
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin
@Api(tags = "角色信息")
public class RoleController {
    @Autowired
    private RoleService roleService = null;

    @ApiOperation(value = "获取角色分页列表")
    @GetMapping("{page}/{limit}")
    public R index(@ApiParam(name = "page", value = "当前页码", required = true)
                   @PathVariable Long page,

                   @ApiParam(name = "limit", value = "每页记录数", required = true)
                   @PathVariable Long limit,
                   Role role) {
        Page<Role> pageParam = new Page<>(page, limit);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(role.getRoleName())) {
            queryWrapper.like("role_name", role.getRoleName());
        }
        IPage<Role> roleIPage = roleService.page(pageParam, queryWrapper);
        return R.ok().data("items", roleIPage.getRecords()).data("total", pageParam.getTotal());
    }

    @ApiOperation(value = "获取角色")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        Role role = roleService.getById(id);
        return R.ok().data("item", role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public R save(@RequestBody Role role) {
        roleService.save(role);
        return R.ok();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public R updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return R.ok();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        roleService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("batchRemove")
    public R batchRemove(@RequestBody List<String> idList) {
        roleService.removeByIds(idList);
        return R.ok();
    }
}
