var SensorData = require('../model/sensor-data');

function ParseUtils() {};

ParseUtils.parseSensorData = function(bytes) { 
	var temperature = parseInt(bytes.substr(4, 2)+bytes.substr(2, 2), 16);
	if(temperature > 0x8000) {
	    temperature = temperature - 0x10000;
    }
    temperature = temperature / 10.0;
    var humidity = parseInt(bytes.substr(8, 2), 16);
    var battery = parseInt(bytes.substr(18, 2), 16);

    var sensorData = new SensorData();
    sensorData.setTemperature(temperature);
    sensorData.setHumidity(humidity);
    sensorData.setBattery(battery);
    return sensorData;
};

module.exports = ParseUtils;