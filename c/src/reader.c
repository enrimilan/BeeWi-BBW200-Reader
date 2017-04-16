/*
 *
 *  GattLib - GATT Library
 *
 *  Copyright (C) 2016-2017  Olivier Martin <olivier@labapart.org>
 *
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "../lib/gattlib/include/gattlib.h"
#include "parse-utils.h"

#define UUID "a8b3fb43-4834-4051-89d0-3de95cddd318"
#define MAC ""

int main() {

    if(MAC == "") {
        fprintf(stderr, "Mac address of device missing.\n");
        return EXIT_FAILURE;
    }

    uuid_t g_uuid;
    gattlib_string_to_uuid(UUID, strlen(UUID) + 1, &g_uuid);

    gatt_connection_t* connection = gattlib_connect(NULL, MAC, BDADDR_LE_PUBLIC, BT_SEC_LOW, 0, 0);
    if (connection == NULL) {
        fprintf(stderr, "Fail to connect to the bluetooth device.\n");
        return EXIT_FAILURE;
    }

	uint8_t buf[100];
	size_t len = sizeof(buf);
    if(gattlib_read_char_by_uuid(connection, &g_uuid, buf, &len) != 0) {
        fprintf(stderr, "An error occurred.\n");
        return EXIT_FAILURE;
    }

    char data[21];
    char* format = "%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x";
    snprintf(data, 21, format, buf[0], buf[1], buf[2], buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9]);
    printf("raw data:\n");
    printf("%s\n", data);

    struct sensor_data sensor_data = parse_sensor_data(data);
    printf("temperature: %.1f°C\n", sensor_data.temperature);
    printf("humidity: %d%%\n", sensor_data.humidity);
    printf("battery: %d%%\n", sensor_data.battery);

	gattlib_disconnect(connection);

	return EXIT_SUCCESS;
}