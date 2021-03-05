package com.example.webservicedemo.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JDBCUtil
 * @Description TODO
 * @Author zhangz
 * @Date 2021/1/19 11:20 上午
 */
public class JDBCUtil {
    private static DruidDataSource dataSource;

    static {
        Properties properties = ProPertiesUtil.getProperties("application.properties");
        // 使用德鲁伊数据库连接池工厂类
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象（从数据库连接池中获取）
     *
     * @return 连接对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            return null;
        }
        return connection;
    }

    /**
     * 关闭jdbc资源对象
     *
     * @param connection 连接对象
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
