using System;
using System.Globalization;
using Reader.Model;
using Reader.Reader;
using Reader.Util;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace Reader
{

    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
            getData();
        }

        private async void getData()
        {
            try
            {
                ISensorReader sensorReader = (ISensorReader)Activator.CreateInstance(Type.GetType(Constants.READER));
                string[] rawData = await sensorReader.ReadRawData();
                SensorData sensorData = ParseUtils.ParseSensorData(rawData);
                cpb.Visibility = Visibility.Collapsed;
                Temperature.Text = sensorData.Temperature.ToString(CultureInfo.InvariantCulture) + "°C";
                Humidity.Text = "humidity: " + sensorData.Humidity + "%";
                Battery.Text = "battery: " + sensorData.Battery + "%";
            }
            catch(Exception e)
            {
                cpb.Visibility = Visibility.Collapsed;
                Error.Text = e.Message;
            }
            
        }
    }
}
