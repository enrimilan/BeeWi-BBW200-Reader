using System;
using System.Diagnostics;
using System.Globalization;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Reader.Util;
using Windows.Devices.Bluetooth;
using Windows.Devices.Bluetooth.GenericAttributeProfile;

namespace Reader.Reader
{
    class GattSensorReader : ISensorReader
    {

        private static string SERVICE_GUID = "a8b3fa04-4834-4051-89d0-3de95cddd318";
        private static string CHARACTERISTIC_GUID = "a8b3fb43-4834-4051-89d0-3de95cddd318";

        public async Task<string[]> ReadRawData()
        {
            if(Constants.MAC_ADDRESS.Length == 0)
            {
                throw new Exception("Mac address missing in Constants.cs");
            }
            
            BluetoothLEDevice device = await BluetoothLEDevice.FromBluetoothAddressAsync(ulong.Parse(Constants.MAC_ADDRESS, NumberStyles.HexNumber));

            if (device == null)
            {
                throw new Exception("Can't connect to device. Make sure bluetooth is turned on and your mac address is correct");
            }

            var services = await device.GetGattServicesAsync();
            GattDeviceServicesResult servicesResult = await device.GetGattServicesForUuidAsync(new Guid(SERVICE_GUID));
            GattCharacteristicsResult characteristicsResult = await servicesResult.Services.First().GetCharacteristicsForUuidAsync(new Guid(CHARACTERISTIC_GUID));
            GattReadResult result = await characteristicsResult.Characteristics.First().ReadValueAsync(BluetoothCacheMode.Uncached);
            byte[] bytes = result.Value.ToArray();

            string[] data = new string[10];
            Debug.WriteLine("raw data:");
            for (int i = 0; i < bytes.Length; i++)
            {
                data[i] = bytes[i].ToString("X2");
                Debug.Write(data[i] + " ");
            }
            Debug.WriteLine("");

            return data;
        }
    }
}
