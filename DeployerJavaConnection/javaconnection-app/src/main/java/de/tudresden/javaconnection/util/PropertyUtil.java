package de.tudresden.javaconnection.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static Properties properties;
    public static synchronized Properties getInstance() {
        if(properties == null) {
            try(InputStream resourceStream = new FileInputStream("src/main/resources/ganache.properties")) {
                properties = new Properties();
                if(resourceStream != null) {
                    properties.load(resourceStream);
                }
            } catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }
        return properties;
    }
}
