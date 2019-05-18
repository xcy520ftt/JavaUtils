package com.heima.travel.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据源的工具类
 */
public class C3p0Utils {
    /**
     * 创建私有静态数据源成员变量
     */
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    /**
     * 创建公有的得到数据源的方法
     *
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 创建得到连接对象的方法
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建释放资源的方法
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }


}
