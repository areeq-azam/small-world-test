package org.swfs.coreUtils.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {

    public static Properties getConfig(String configName) {
        Properties propertyFile = new Properties();

        try {
            File config = new File(
                System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                "main" +
                File.separator +
                "resources" +
                File.separator +
                configName +
                ".properties"
            );
            if (config.exists()) {
                propertyFile.load(new FileInputStream(config));
            }
        } catch (Exception ex) {}
        return propertyFile;
    }
}
