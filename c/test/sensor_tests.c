#include <stdio.h>
#include <stdlib.h>
#include "minunit.h"
#include "../src/parse-utils.h"

#define KGRN  "\x1B[32m"
#define KRED  "\x1B[31m"

int tests_run = 0;

static char* test_1() {
    struct sensor_data sensor_data = parse_sensor_data("00FF000224070000064c");
    float expected_temperature = 25.5;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    int expected_humidity = 36;
    char* error_humidity = (char*) malloc(64);
    snprintf(error_humidity, 64, "Humidity: expected %d but was %d", expected_humidity, sensor_data.humidity);
    mu_assert(error_humidity, sensor_data.humidity == expected_humidity);
    free(error_humidity);

    int expected_battery = 76;
    char* error_battery = (char*) malloc(64);
    snprintf(error_battery, 64, "Battery: expected %d but was %d", expected_battery, sensor_data.battery);
    mu_assert(error_battery, sensor_data.battery == expected_battery);
    free(error_battery);

    return 0;
}

static char* test_2() {
    struct sensor_data sensor_data = parse_sensor_data("0000010224070000064c");

    float expected_temperature = 25.6;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_3() {
    struct sensor_data sensor_data = parse_sensor_data("00FE000224070000064c");

    float expected_temperature = 25.4;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_4() {
    struct sensor_data sensor_data = parse_sensor_data("0052030224070000064c");

    float expected_temperature = 85.0;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_5() {
    struct sensor_data sensor_data = parse_sensor_data("006F000224070000064c");

    float expected_temperature = 11.1;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_6() {
    struct sensor_data sensor_data = parse_sensor_data("000A000224070000064c");

    float expected_temperature = 1.0;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_7() {
    struct sensor_data sensor_data = parse_sensor_data("0001000224070000064c");

    float expected_temperature = 0.1;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_8() {
    struct sensor_data sensor_data = parse_sensor_data("0000000224070000064c");

    float expected_temperature = 0.0;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

     return 0;
}

static char* test_9() {
    struct sensor_data sensor_data = parse_sensor_data("00FFFF0224070000064c");

    float expected_temperature = -0.1;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_10() {
    struct sensor_data sensor_data = parse_sensor_data("00F6FF0224070000064c");

    float expected_temperature = -1.0;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_11() {
    struct sensor_data sensor_data = parse_sensor_data("0091FF0224070000064c");

    float expected_temperature = -11.1;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_12() {
    struct sensor_data sensor_data = parse_sensor_data("003BFF0224070000064c");

    float expected_temperature = -19.7;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* test_13() {
    struct sensor_data sensor_data = parse_sensor_data("0038FF0224070000064c");

    float expected_temperature = -20.0;
    char* error_temperature = (char*) malloc(64);
    snprintf(error_temperature, 64, "Temperature: expected %.1f but was %.1f", expected_temperature, sensor_data.temperature);
    mu_assert(error_temperature, sensor_data.temperature == expected_temperature);
    free(error_temperature);

    return 0;
}

static char* all_tests() {
    mu_run_test(test_1);
    mu_run_test(test_2);
    mu_run_test(test_3);
    mu_run_test(test_4);
    mu_run_test(test_5);
    mu_run_test(test_6);
    mu_run_test(test_7);
    mu_run_test(test_8);
    mu_run_test(test_9);
    mu_run_test(test_10);
    mu_run_test(test_11);
    mu_run_test(test_12);
    mu_run_test(test_13);

    return 0;
}

int main(int argc, char **argv) {

    char *result = all_tests();
    if (result != 0) {
        printf("%s%s\n", KRED, result);
    }
    else {
        printf("%sALL TESTS PASSED\n", KGRN);
    }
    printf("Tests run: %d\n", tests_run);

    return 0;
}