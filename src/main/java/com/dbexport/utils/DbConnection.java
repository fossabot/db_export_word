package com.dbexport.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 类说明:JDBC连接
 *
 * @author yuntian 317526763@qq.com
 * @author yuntian 317526763@qq.com
 * @date 2018/10/30/0030.
 */
public class DbConnection {
    public static Connection getConn(String jdbcUrl, String userName, String password, String driverClassName) throws Exception {
        Class.forName(driverClassName);
        return DriverManager.getConnection(jdbcUrl, userName, password);
    }

    public static void closeRs(ResultSet rs) throws Exception {
        if (rs != null) {
            Statement statement = rs.getStatement();
            if (statement != null) {
                Connection connection = statement.getConnection();
                if (connection != null) {
                    rs.close();
                    statement.close();
                    connection.close();
                }
            }
        }
        System.out.println("已关闭数据库连接");
    }

    public static void closeStat(Statement statement) throws Exception {
        if (statement != null) {
            Connection connection = statement.getConnection();
            if (connection != null) {
                statement.close();
                connection.close();
            }
        }
        System.out.println("已关闭数据库连接");

    }

    public static void closeConn(Connection connection) throws Exception {

        if (connection != null) {

            connection.close();
        }
        System.out.println("已关闭数据库连接");

    }
}
