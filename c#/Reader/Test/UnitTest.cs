using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Reader.Model;
using Reader.Util;

namespace Test
{
    [TestClass]
    public class SensorTests
    {
        [TestMethod]
        public void TestMethod1()
        {
            String[] bytes = "00 FF 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(25.5, sensorData.Temperature);
            Assert.AreEqual(36, sensorData.Humidity);
            Assert.AreEqual(76, sensorData.Battery);
        }

        [TestMethod]
        public void TestMethod2()
        {
            String[] bytes = "00 00 01 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(25.6, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod3()
        {
            String[] bytes = "00 FE 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(25.4, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod4()
        {
            String[] bytes = "00 52 03 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(85.0, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod5()
        {
            String[] bytes = "00 6F 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(11.1, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod6()
        {
            String[] bytes = "00 0A 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(1.0, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod7()
        {
            String[] bytes = "00 01 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(0.1, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod8()
        {
            String[] bytes = "00 00 00 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(0.0, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod9()
        {
            String[] bytes = "00 FF FF 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(-0.1, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod10()
        {
            String[] bytes = "00 F6 FF 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(-1.0, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod11()
        {
            String[] bytes = "00 91 FF 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(-11.1, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod12()
        {
            String[] bytes = "00 3B FF 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(-19.7, sensorData.Temperature);
        }

        [TestMethod]
        public void TestMethod13()
        {
            String[] bytes = "00 38 FF 02 24 07 00 00 06 4c".Split(' ');
            SensorData sensorData = ParseUtils.ParseSensorData(bytes);
            Assert.AreEqual(-20.0, sensorData.Temperature);
        }
        
    }
}
