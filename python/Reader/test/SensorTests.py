import unittest

from src.utils.ParseUtils import ParseUtils

class SensorTests(unittest.TestCase):

    def test_1(self):
        bytes = "00 FF 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(25.5, sensorData.temperature)
        self.assertEquals(36, sensorData.humidity)
        self.assertEquals(76, sensorData.battery)

    def test_2(self):
        bytes = "00 00 01 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(25.6, sensorData.temperature)

    def test_3(self):
        bytes = "00 FE 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(25.4, sensorData.temperature)

    def test_4(self):
        bytes = "00 52 03 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(85.0, sensorData.temperature)

    def test_5(self):
        bytes = "00 6F 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(11.1, sensorData.temperature)

    def test_6(self):
        bytes = "00 0A 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(1.0, sensorData.temperature)

    def test_7(self):
        bytes = "00 01 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(0.1, sensorData.temperature)

    def test_8(self):
        bytes = "00 00 00 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(0.0, sensorData.temperature)

    def test_9(self):
        bytes = "00 FF FF 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(-0.1, sensorData.temperature)

    def test_10(self):
        bytes = "00 F6 FF 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(-1.0, sensorData.temperature)

    def test_11(self):
        bytes = "00 91 FF 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(-11.1, sensorData.temperature)

    def test_12(self):
        bytes = "00 3B FF 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(-19.7, sensorData.temperature)

    def test_13(self):
        bytes = "00 38 FF 02 24 07 00 00 06 4c".split(" ")
        sensorData = ParseUtils.parseSensorData(bytes)
        self.assertEquals(-20.0, sensorData.temperature)

if __name__ == '__main__':
    unittest.main()
