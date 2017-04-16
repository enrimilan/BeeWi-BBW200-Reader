#!/bin/bash

mkdir -p bin

# compile and link
/usr/bin/cc src/parse-utils.c  test/sensor_tests.c -o bin/sensor_tests

# run
bin/sensor_tests

