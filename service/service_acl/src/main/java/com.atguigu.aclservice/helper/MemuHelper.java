package com.atguigu.aclservice.helper;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/6/2417:38
 */

import com.alibaba.fastjson.JSONObject;
import com.atguigu.aclservice.entity.Permission;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkjy
 * @version 1.0
 * @description zkjy
 * @updateUser
 * @createDate 2021/6/24 17:38
 * @updateDate 2021/6/24 17:38
 **/
public class MemuHelper {
    /**
     * 构建菜单
     */
    public static List<JSONObject> build(List<Permission> treeNodes) {
        List<JSONObject> meuns = new ArrayList<>();
        if (treeNodes.size() == 1) {
            Permission topNode = treeNodes.get(0);
            //左侧一级菜单
            List<Permission> oneMeunList = topNode.getChildren();
            for (Permission one : oneMeunList) {
                JSONObject oneMenu = new JSONObject();
                oneMenu.put("path", one.getPath());

                oneMenu.put("component", one.getComponent());
                oneMenu.put("redirect", "noredirect");
                oneMenu.put("name", "name_" + one.getId());
                oneMenu.put("hidden", false);

                JSONObject oneMeta = new JSONObject();
                oneMeta.put("title", one.getName());
                oneMeta.put("icon", one.getIcon());
                oneMenu.put("meta", oneMeta);
                List<JSONObject> children = new ArrayList<>();
                List<Permission> twoMeunList = one.getChildren();
                for (Permission two : twoMeunList) {
                    JSONObject twoMenu = new JSONObject();
                    twoMenu.put("path", two.getPath());
                    twoMenu.put("component", two.getComponent());
                    twoMenu.put("name", "name_" + two.getId());
                    twoMenu.put("hidden", false);

                    JSONObject twoMeta = new JSONObject();
                    twoMeta.put("title", two.getName());
                    twoMenu.put("meta", twoMeta);
                    children.add(twoMenu);

                    List<Permission> threeMeunList = two.getChildren();
                    for (Permission three : threeMeunList) {
                        if (StringUtils.isEmpty(three.getPath())) continue;

                        JSONObject threeMeun = new JSONObject();
                        threeMeun.put("path", three.getPath());
                        threeMeun.put("component", three.getComponent());
                        threeMeun.put("name", "name_" + three.getId());
                        threeMeun.put("hidden", true);

                        JSONObject threeMeta = new JSONObject();
                        threeMeta.put("title", three.getName());
                        threeMeta.put("meta", threeMeta);
                        children.add(threeMeun);
                    }
                }
                oneMenu.put("children", children);
                meuns.add(oneMenu);
            }
        }
        return meuns;
    }
}
