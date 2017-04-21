import sys
import os.path
sys.path.append(os.path.join(os.path.dirname(__file__), '..'))

from model.SensorData import SensorData

class ParseUtils:

    @staticmethod
    def parseSensorData(bytes):
        temperature = int(bytes[2] + bytes[1], 16)
        if (temperature > 0x8000):
            temperature = temperature - 0x10000

        temperature = temperature / 10.0

        humidity = int(bytes[4], 16)
        battery = int(bytes[9], 16)
        return SensorData(temperature, humidity, battery)