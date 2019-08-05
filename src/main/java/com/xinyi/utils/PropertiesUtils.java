package com.xinyi.utils;

import com.xinyi.constant.Constant;

import java.io.InputStream;
import java.util.Properties;

/**
 * 功能说明:
 * author: haonan.bian
 * date: 2018/10/18 11:25
 * Copyright (C)1997-2018 深圳信义科技 All rights reserved.
 */
public class PropertiesUtils {

    public static Properties getProperties(){
        try{
            Properties props = new Properties();
            InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream(Constant.PROPERTY_FILE_NAME);
            props.load(in);
            return props;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String  getParam(String key) {
        Properties props = new Properties();
        try {
            InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream(Constant.PROPERTY_FILE_NAME);
            props.load(in);
            in.close();
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
