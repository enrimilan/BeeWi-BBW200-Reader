package com.enrimilan.reader.util;

import com.enrimilan.reader.model.SensorData;

public class ParseUtils {

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
