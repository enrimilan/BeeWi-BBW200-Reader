# BeeWi BBW200 reader in c

## Prerequisites
+ CMake
* GLib
* Gattlib
### Linux (Debian)
```
sudo apt-get install libglib2.0-dev
sudo apt-get install cmake
sudo apt-get install libbluetooth-dev libreadline-dev
```


## Build, test and run
Don't forget to add the mac address of your sensor in `reader.c`.

```
sudo ./run-tests.sh
sudo ./build.sh
sudo ./bin/reader
```