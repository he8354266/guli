package com.atguigu.aclservice.helper;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2514:21
 */

import com.atguigu.aclservice.entity.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description 根据权限数据构建菜单数据
 * @updateUser
 * @createDate 2021/6/25 14:21
 * @updateDate 2021/6/25 14:21
 **/
public class PermissionHelper {

    /**
     * @Description 使用递归方法建菜单
     * @Author zkjy
     * @param:
     * @return:
     */
    public static List<Permission> bulid(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>();
        for (Permission treeNode : treeNodes) {
            if ("0".equals(treeNode.getPid())) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }


    /**
     * @param treeNodes
     * @return Permission
     * @Description 递归查找子节点
     * @Author zkjy
     */
    public static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {
        treeNode.setChildren(treeNodes);
        for (Permission it : treeNodes) {
            if (treeNode.getPid().equals(it.getPid())) {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
