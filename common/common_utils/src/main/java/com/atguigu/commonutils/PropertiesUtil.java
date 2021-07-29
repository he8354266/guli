package com.atguigu.commonutils;/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2021/7/510:44
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @description zkjy
 * @author zkjy
 * @updateUser
 * @createDate 2021/7/5 10:44
 * @updateDate 2021/7/5 10:44     
 * @version 1.0
 **/
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    static {
        String fileName = "mmall.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());

        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());

        return value.trim();
    }

}
