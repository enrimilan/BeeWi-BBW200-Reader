import model.SensorData;
import reader.ISensorReader;
import util.ParseUtils;

public class Main {

    private ISensorReader sensorReader;

    public Main(ISensorReader sensorReader) {
        this.sensorReader = sensorReader;
    }

    private void getData() {
        ParseUtils.getProperties();
        String rawData = sensorReader.readRawData();
        System.out.println("raw data:");
        System.out.println(rawData);

        String[] bytes = rawData.split(":")[1].trim().split(" ");
        SensorData sensorData = ParseUtils.parseSensorData(bytes);
        System.out.println("temperature: " + sensorData.getTemperature()+"°C");
        System.out.println("humidity: " + sensorData.getHumidity() + "%");
        System.out.println("battery: " + sensorData.getBattery() + "%");
    }

    public static void main(String[] args) throws Exception {
        String className = ParseUtils.getProperties().getProperty("reader");
        ISensorReader sensorReader = (ISensorReader) Class.forName(className).newInstance();
        Main main = new Main(sensorReader);
        main.getData();
    }

}
