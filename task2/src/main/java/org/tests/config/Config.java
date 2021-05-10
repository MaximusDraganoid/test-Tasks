package org.tests.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties = new Properties();

    public static String getProperty(String propertyName) {
        if (properties.isEmpty()) {
            try (InputStream inputStream = Config.class
                    .getClassLoader()
                    .getResourceAsStream("db_connection.properties")) {
                properties.load(inputStream);
            } catch (IOException ex) {
                System.out.println("Loading properties error: " + ex.getMessage());
                throw new RuntimeException(ex);
            }
        }

        return properties.getProperty(propertyName);
    }

}
