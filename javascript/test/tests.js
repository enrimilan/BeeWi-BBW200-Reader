var chai = require('chai');
var expect = chai.expect;
var ParseUtils = require('../src/main/util/parse-utils');

describe('Sensor tests', function() {

    it('00FF should be 25.5°C', function() {
        var sensorData = ParseUtils.parseSensorData("00FF000224070000064c");
        expect(sensorData.getTemperature()).to.equal(25.5);
        expect(sensorData.getBattery()).to.equal(76);
        expect(sensorData.getHumidity()).to.equal(36);
    });

    it('0100 should be 25.6°C', function() {
        var sensorData = ParseUtils.parseSensorData("0000010224070000064c");
        expect(sensorData.getTemperature()).to.equal(25.6);
    });

    it('00FE should be 25.4°C', function() {
        var sensorData = ParseUtils.parseSensorData("00FE000224070000064c");
        expect(sensorData.getTemperature()).to.equal(25.4);
    });

    it('0352 should be 85.0°C', function() {
        var sensorData = ParseUtils.parseSensorData("0052030224070000064c");
        expect(sensorData.getTemperature()).to.equal(85.0);
    });

    it('006F should be 11.1°C', function() {
        var sensorData = ParseUtils.parseSensorData("006F000224070000064c");
        expect(sensorData.getTemperature()).to.equal(11.1);
    });

    it('000A should be 1.0°C', function() {
        var sensorData = ParseUtils.parseSensorData("000A000224070000064c");
        expect(sensorData.getTemperature()).to.equal(1.0);
    });

    it('0001 should be 0.1°C', function() {
        var sensorData = ParseUtils.parseSensorData("0001000224070000064c");
        expect(sensorData.getTemperature()).to.equal(0.1);
    });

    it('0000 should be 0.0°C', function() {
        var sensorData = ParseUtils.parseSensorData("0000000224070000064c");
        expect(sensorData.getTemperature()).to.equal(0.0);
    });

    it('FFFF should be -0.1°C', function() {
        var sensorData = ParseUtils.parseSensorData("00FFFF0224070000064c");
        expect(sensorData.getTemperature()).to.equal(-0.1);
    });

    it('FFF6 should be -1.0°C', function() {
        var sensorData = ParseUtils.parseSensorData("00F6FF0224070000064c");
        expect(sensorData.getTemperature()).to.equal(-1.0);
    });

    it('FF91 should be -11.1°C', function() {
        var sensorData = ParseUtils.parseSensorData("0091FF0224070000064c");
        expect(sensorData.getTemperature()).to.equal(-11.1);
    });

    it('FF3B should be -19.7°C', function() {
        var sensorData = ParseUtils.parseSensorData("003BFF0224070000064c");
        expect(sensorData.getTemperature()).to.equal(-19.7);
    });

    it('FF38 should be -20.0°C', function() {
        var sensorData = ParseUtils.parseSensorData("0038FF0224070000064c");
        expect(sensorData.getTemperature()).to.equal(-20.0);
    });

});