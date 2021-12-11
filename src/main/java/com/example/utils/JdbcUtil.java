package com.example.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    private static final DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(OutConfig.getProp("url"));
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection createConnection(){
        try{
            Class.forName(OutConfig.getProp("driver"));
            return DriverManager.getConnection(OutConfig.getProp("url"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
