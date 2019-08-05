package com.xinyi.utils;

import com.xinyi.constant.Constant;

import java.sql.Connection;
import java.sql.DriverManager;

public class GreenPlumUtils {

    public static Connection getConnection(){
        try{
            Class.forName(Constant.GP_CLASS_NAME);
            Connection connection = DriverManager.getConnection(Constant.GP_URL, Constant.GP_USERNAME, Constant.GP_PASSWORD);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
