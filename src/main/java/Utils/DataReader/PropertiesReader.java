package Utils.DataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final Properties properties;

    public PropertiesReader(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
