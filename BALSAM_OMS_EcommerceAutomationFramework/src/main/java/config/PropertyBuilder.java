package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import constants.Constants;
import enums.ConfigProperties;
import exceptions.PropertyFileHandleException;

// Your PropertyBuilder class
public final class PropertyBuilder {

    private PropertyBuilder() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    static {
        readPropertyFile(Constants.getWebtestPropertyFilePath());
    }

    public static String getPropValue(ConfigProperties key) {
        if (Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileHandleException("Property name " + key + " is not found. Please check config Properties");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }
    
    public static String getPropValue(ConfigProperties key, String defaultValue) {
        String value = CONFIG_MAP.get(key.name().toLowerCase());
        return (value != null) ? value : defaultValue;
    }

    // Overloaded method to get property with a specific module name
    public static String getPropValue(String name, ConfigProperties key) {
        if (Objects.isNull(CONFIG_MAP.get(name.toLowerCase() + key.name().toLowerCase()))) {
            throw new PropertyFileHandleException(
                    "Property name " + name + key + " is not found. Please check config Properties");
        }
        return CONFIG_MAP.get(name.toLowerCase() + key.name().toLowerCase());
    }

    private static void readPropertyFile(String path) {
        try (FileInputStream envFile = new FileInputStream(path)) {
            property.load(envFile);

            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIG_MAP.put(String.valueOf(entry.getKey()).toLowerCase(), String.valueOf(entry.getValue()).trim());
            }

        } catch (IOException e) {
            throw new PropertyFileHandleException("Error reading property file: " + e.getMessage(), e);
        }
    }
}
