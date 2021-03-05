package com.example.webservicedemo;


import com.example.webservicedemo.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@WebService
public class AserviceImpl implements Aservice {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String getUser() {
        QueryRunner queryRunner = new QueryRunner();
        //获取Connection连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user order by id desc limit 1";
        Map<String, Object> objectMap = null;
        try {
            objectMap = queryRunner.query(connection, sql, new MapHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (String) objectMap.get("username");
    }

    @Override
    public String addUser(String username, String desc, String content) {
        //创建QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();
        //获取Connection连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql语句
        String sql = "insert into user(`username`, `description`, `content`) VALUES(?,?,?)";
        try {
            assert connection != null;
            int update = queryRunner.update(connection, sql, username, desc, content);
            System.out.println(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return "Your message is :" + username;
    }

    @Override
    public String getMessage2() {
        return "这个不会被发布";
    }

}
