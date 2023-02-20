package ru.itis.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Settings {
    private static final Properties properties;
    public static String file = "src/test/resources/settings.xml";
    private static String baseUrl;
    private static String mailUrl;
    private static String login;
    private static String password;

    static {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            properties = new Properties();
            properties.loadFromXML(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) baseUrl = properties.getProperty("BaseUrl");
        return baseUrl;
    }

    public static String getMailUrl() {
        if (mailUrl == null) mailUrl = properties.getProperty("MailUrl");
        return mailUrl;
    }

    public static String getLogin() {
        if (login == null) login = properties.getProperty("Login");
        return login;
    }

    public static String getPassword() {
        if (password == null) password = properties.getProperty("Password");
        return password;
    }
}
