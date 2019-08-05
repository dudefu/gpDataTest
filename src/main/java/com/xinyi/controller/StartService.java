package com.xinyi.controller;

import com.xinyi.utils.GreenPlumUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能说明: greenplum数据接口测试
 * author: defu.du
 * date: 2019/08/05 09:44:30
 *
 */
@Controller
public class StartService {

    private Connection conn;
    private String sqlStr;
    private StringBuilder stringBuilder;
    private ResultSet rs;

    StartService() {
        conn = GreenPlumUtils.getConnection();
    }

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    @ResponseBody
    public String test(String sql) {

        sqlStr = sql;
        try {
            Statement pre = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //pre = conn.prepareStatement(sqlStr);
            rs = pre.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            stringBuilder = new StringBuilder();
            rs.last();
            int rowCount = rs.getRow();
            int count = 0;
            rs = pre.executeQuery(sql);
            while (rs.next()) {
                count++;
                stringBuilder.append("{");
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    String columnName = metaData.getColumnName(i);
                    stringBuilder.append("\"" + columnName + "\"" + ":" + "\"" + rs.getString(i) + "\"");
                    if (i < metaData.getColumnCount()) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("}");
                if (count < rowCount) {
                    stringBuilder.append(",");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("[" + stringBuilder.toString() + "]");
        return "[" + stringBuilder.toString() + "]";
    }

}
