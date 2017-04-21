package com.enrimilan.reader;

import org.junit.Test;

import com.enrimilan.reader.model.SensorData;
import com.enrimilan.reader.util.ParseUtils;

import static org.junit.Assert.*;

public class SensorTests {

    @Test
    public void test_1() {
        String[] bytes = "00 FF 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(25.5, sensorData.getTemperature(), 0);
        assertEquals(36, sensorData.getHumidity());
        assertEquals(76, sensorData.getBattery());
    }

    @Test
    public void test_2() {
        String[] bytes = "00 00 01 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(25.6, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_3() {
        String[] bytes = "00 FE 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(25.4, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_4() {
        String[] bytes = "00 52 03 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(85.0, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_5() {
        String[] bytes = "00 6F 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(11.1, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_6() {
        String[] bytes = "00 0A 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(1.0, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_7() {
        String[] bytes = "00 01 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(0.1, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_8() {
        String[] bytes = "00 00 00 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(0.0, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_9() {
        String[] bytes = "00 FF FF 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(-0.1, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_10() {
        String[] bytes = "00 F6 FF 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(-1.0, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_11() {
        String[] bytes = "00 91 FF 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(-11.1, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_12() {
        String[] bytes = "00 3B FF 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(-19.7, sensorData.getTemperature(), 0);
    }

    @Test
    public void test_13() {
        String[] bytes = "00 38 FF 02 24 07 00 00 06 4c".split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        assertEquals(-20.0, sensorData.getTemperature(), 0);
    }
}