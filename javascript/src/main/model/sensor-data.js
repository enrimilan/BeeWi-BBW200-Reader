"use strict";
class SensorData {

	getTemperature() {
        return this.temperature;
    }

    setTemperature(temperature) {
        this.temperature = temperature;
    }

    getHumidity() {
        return this.humidity;
    }

    setHumidity(humidity) {
        this.humidity = humidity;
    }

    getBattery() {
        return this.battery;
    }

    setBattery(battery) {
        this.battery = battery;
    }
}

module.exports = SensorData;