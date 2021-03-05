package com.example.webservicedemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ProPertiesUtil
 * @Description TODO
 * @Author zhangz
 * @Date 2021/1/19 11:19 上午
 */
public class ProPertiesUtil {
    /**
     * @param fileName 文件名称
     */
    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ProPertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回Properties对象
        return properties;
    }
}
