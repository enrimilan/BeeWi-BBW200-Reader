# BeeWi BBW200 reader in c

## Prerequisites
* GLib
* Gattlib
### Linux (Debian)
`sudo apt-get install libbluetooth-dev libreadline-dev`


## Build, test and run
Don't forget to add the mac address of your sensor in `reader.c`.

```
sudo ./run-tests.sh
sudo ./build.sh
```