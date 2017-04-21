using System.Diagnostics;
using Reader.Model;

namespace Reader.Util
{
    class ParseUtils
    {
        public static SensorData ParseSensorData(string[] bytes)
        {
            SensorData sensorData = new SensorData();

            var temperature = int.Parse(bytes[2] + bytes[1], System.Globalization.NumberStyles.HexNumber);
            if (temperature > 0x8000)
            {
                temperature = temperature - 0x10000;
            }
            sensorData.Temperature = temperature / 10.0;
            Debug.WriteLine("temperature: " + sensorData.Temperature);

            sensorData.Humidity = int.Parse(bytes[4] + "", System.Globalization.NumberStyles.HexNumber);
            Debug.WriteLine("humidity: " + sensorData.Humidity);

            sensorData.Battery = int.Parse(bytes[9] + "", System.Globalization.NumberStyles.HexNumber);
            Debug.WriteLine("battery: " + sensorData.Battery);

            return sensorData;
        }
    }
}
