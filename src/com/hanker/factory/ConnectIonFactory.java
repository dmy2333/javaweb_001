package com.hanker.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectIonFactory {
    /*
     * 获取连接的方法
     * */
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);
        String url = pro.getProperty("url");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("driver");
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
