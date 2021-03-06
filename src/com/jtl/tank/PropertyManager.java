package com.jtl.tank;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jtl
 * @date 2021/8/3 16:25
 */

public class PropertyManager {
    private Properties mProperties;

    private PropertyManager() {
        try {
            mProperties = new Properties();
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config");
            mProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyManager getInstance() {
        return PropertyHolder.PROPERTY_MANAGER;
    }

    public String getString(String key) {
        return mProperties.getProperty(key, "");
    }

    public int getInt(String key) {
        return (int) mProperties.getOrDefault(key, 0);
    }

    public boolean getBoolean(String key) {
        return (boolean) mProperties.getOrDefault(key, false);
    }


    private static class PropertyHolder {
        private static final PropertyManager PROPERTY_MANAGER = new PropertyManager();
    }
}
