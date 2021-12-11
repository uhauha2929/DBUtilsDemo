package com.example.utils;

import java.io.*;
import java.util.Properties;

public class OutConfig {

    public static String USER_DIR = System.getProperty("user.dir");
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(USER_DIR + File.separator + "db.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        return properties.getProperty(key);
    }
}
