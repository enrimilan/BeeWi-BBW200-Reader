#include <stdio.h>
#include <stdlib.h>
#include "parse-utils.h"

struct sensor_data parse_sensor_data(char* data) {

    struct sensor_data sensor_data;

    char temperature_buf[4];
    temperature_buf[0] = data[4];
	temperature_buf[1] = data[5];
	temperature_buf[2] = data[2];
	temperature_buf[3] = data[3];
	int temperature = strtol(temperature_buf, NULL, 16);
    if(temperature > 0x8000) {
	    temperature = temperature - 0x10000;
    }
    sensor_data.temperature = temperature / 10.0;

    char humidity_buf[2];
    humidity_buf[0] = data[8];
    humidity_buf[1] = data[9];
    sensor_data.humidity = strtol(humidity_buf, NULL, 16);

    char battery_buf[2];
    battery_buf[0] = data[18];
    battery_buf[1] = data[19];
    sensor_data.battery = strtol(battery_buf, NULL, 16);

    return sensor_data;
}
