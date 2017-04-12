package util;

import exception.ConfigErrorException;
import model.SensorData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParseUtils {

    private static final String PROPERTIES_FILE = "config.properties";
    private static Properties props;

    public static Properties getProperties() {
        if(props == null) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props = new Properties();
            try(InputStream resourceStream = loader.getResourceAsStream(PROPERTIES_FILE)) {
                props.load(resourceStream);
                if(props.getProperty("reader").isEmpty() || props.getProperty("hci").isEmpty() || props.getProperty("mac").isEmpty()) {
                    throw new ConfigErrorException("Configuration(s) missing in config.properties");
                }
            } catch (IOException e) {
                throw new ConfigErrorException(e);
            }
        }

        return props;

    }

    public static SensorData parseSensorData(String[] bytes) {

        double temperature = Integer.valueOf(bytes[2]+bytes[1],16).shortValue() / 10.0;
        int humidity = Integer.parseInt(bytes[4], 16 );
        int battery = Integer.parseInt(bytes[9], 16 );

        SensorData sensorData = new SensorData();
        sensorData.setTemperature(temperature);
        sensorData.setHumidity(humidity);
        sensorData.setBattery(battery);
        return sensorData;
    }
}
