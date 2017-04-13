var ParseUtils = require('./util/parse-utils');
var noble      = require('noble');
var config     = require('../resources/config');

noble.on('stateChange', function(state) {
    if (state === 'poweredOn') {
        noble.stopScanning();
        noble.startScanning();
    } else {
        noble.stopScanning();
    }
});


noble.on('scanStop', function() {
    process.exit(0);
});


noble.on('discover', function(peripheral) {

    if(config.mac == '') {
        throw "Mac address of the sensor missing in config.js";
    }

    if (peripheral.id == config.mac) {
        var rawData = peripheral.advertisement.manufacturerData.toString('hex');
        console.log("raw data:");
        console.log(rawData);

        var sensorData = ParseUtils.parseSensorData(rawData.substr(6));
        console.log("temperature: " + sensorData.getTemperature() + "°C");
        console.log("humidity: " + sensorData.getHumidity() + "%");
        console.log("battery: " + sensorData.getBattery() + "%");
    }

    noble.stopScanning();
});

