package com.hanker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCUtils {
    /*
     * 获取连接的方法
     * */
    /*public static Connection getConnection() throws Exception {
        Connection conn = null;
        File file = new File("1.jpg");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);
        String url = pro.getPropert `y("url");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("driver");
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }*/
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        /*&characterEncoding=utf-8*/
        String url = "jdbc:mysql://localhost:3306/abc?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    /*
     * 关闭资源的方法
     * */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     *
     * */

    public static void close(Statement stmt, Connection conn) {
        JDBCUtils.close(null, stmt, conn);
    }

    /*
     * 通用的增删改的方法
     * */

    public static int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //3.填充占位符
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn);
        }
        return rows;
    }
    /*
     * 通用的查询方法,针对不同表
     * */

    // 通用的针对于不同表的查询:返回一个对象
    public static <T> T query (Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，得到PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.执行executeQuery(),得到结果集：ResultSet
            rs = ps.executeQuery();
            // 5.得到结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 6.1通过ResultSetMetaData得到columnCount,columnLabel；通过ResultSet得到列值
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t =  clazz.newInstance();
//                System.out.println(t.toString());
                for (int i = 0; i < columnCount; i++) {// 遍历每一个列
                    // 获取列值
                    Object columnVal = rs.getObject(i + 1);
                    // 获取列的别名:列的别名，使用类的属性名充当
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 6.2使用反射，给对象的相应属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.关闭资源
            JDBCUtils.close(rs, ps, conn);
        }
        return null;
    }
}
