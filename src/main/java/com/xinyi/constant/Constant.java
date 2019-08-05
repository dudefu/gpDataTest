package com.xinyi.constant;

import com.xinyi.utils.PropertiesUtils;

import java.util.Properties;

/**
 * 功能说明: GreenPlum 相关配置
 * author: defu.du
 * date: 2019/08/05 09:44:30
 * Copyright (C)1997-2019 深圳信义科技 All rights reserved.
 */
public class Constant {

    private final static Properties prop = PropertiesUtils.getProperties();
    public final static String PROPERTY_FILE_NAME = "application.properties";

    //GreenPlum 相关配置
    public final static String GP_CLASS_NAME = prop.getProperty("gp.class.name");
    public final static String GP_URL = prop.getProperty("gp.url");
    public final static String GP_USERNAME = prop.getProperty("gp.username");
    public final static String GP_PASSWORD = prop.getProperty("gp.password");
    public final static String GP_TABLE_VEHICLE_NAME = prop.getProperty("gp.table.vehicle.name");
    public final static String GP_TABLE_VEHICLE_PATH = prop.getProperty("gp.table.vehicle.path");
    public final static String GP_TABLE_VEHICLE_COLUMNS = prop.getProperty("gp.table.vehicle.columns");
    public final static String GP_TABLE_VEHICLE_COPYIN = prop.getProperty("gp.table.vehicle.copyin");
    public final static String GP_TABLE_VEHICLE_TEMP_SUFFIX = prop.getProperty("gp.table.vehicle.temp.suffix");

}
