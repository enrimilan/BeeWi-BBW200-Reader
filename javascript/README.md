# BeeWi BBW200 reader in JavaScript

## Prerequisites
* Latest version of Node.js
* The package `noble` is used in this implementation, so check https://github.com/sandeepmistry/noble for more
### Linux (Debian)
`sudo apt-get install bluetooth bluez libbluetooth-dev libudev-dev`

### Windows
`npm install --global --production windows-build-tools`

## Build, test and run
Don't forget to complete the configuration file with the mac address of your sensor.

```
sudo npm install
sudo npm test
sudo npm start
```