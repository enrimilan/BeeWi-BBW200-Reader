# coding=utf-8
from reader.GattSensorReader import GattSensorReader
from utils.ParseUtils import ParseUtils

if __name__ == "__main__":
    sensorReader = GattSensorReader()
    rawData = sensorReader.readRawData()
    print("raw data:")
    print(rawData)
    sensorData = ParseUtils.parseSensorData(rawData.split(" "))
    print("temperature: " + str(sensorData.temperature) + "°C")
    print("humidity: " + str(sensorData.humidity) + "%")
    print("battery: " + str(sensorData.battery) + "%")
