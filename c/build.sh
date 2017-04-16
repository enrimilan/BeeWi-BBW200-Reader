#!/bin/bash

mkdir -p bin

# Check if lib sources are to be downloaded and built.
if [ ! -d "lib" ]; then
    mkdir lib
    cd lib
    git clone https://github.com/labapart/gattlib.git
    cd gattlib

    # Use a revision from march 17th, 2017.
    git reset --hard 0ee021f531bc29bb19eb53f3c03637a43feb3c47

    mkdir build && cd build
    cmake ..
    make
    cd ../../..
fi

# Compile
/usr/bin/cc -o bin/parse-utils.c.o -c src/parse-utils.c
/usr/bin/cc -o bin/reader.c.o -c src/reader.c

# Link
/usr/bin/cc -Wall bin/parse-utils.c.o bin/reader.c.o  -o bin/reader -rdynamic lib/gattlib/build/bluez/libgattlib.so -lglib-2.0 -lbluetooth -Wl,-rpath,lib/gattlib/build/bluez