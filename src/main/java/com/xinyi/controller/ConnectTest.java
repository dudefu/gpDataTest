package com.xinyi.controller;

import com.xinyi.utils.GreenPlumUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ConnectTest {

//    select * from t_vehicle_plate LIMIT 40
//    select count(1) from t_vehicle_plate; --77487 1'
//    select count(1) from t_vehicle_plate_count; --262144 1'
//    select count(1) from tmp_vehicle27w; --277260 1'

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String test(String sql){

        Connection conn = GreenPlumUtils.getConnection();
        String sqlStr = sql;
        PreparedStatement pre = null;
        List<String> list = new LinkedList<>();
        StringBuilder str = new StringBuilder() ;
        try {
            pre = conn.prepareStatement(sqlStr);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add("===============》"+rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            str.append(iterator.next().toString()+"\n");
        }
        if(null != str ){
            return str.toString() ;
        }else{
            return "没有数据" ;
        }

    }

}
