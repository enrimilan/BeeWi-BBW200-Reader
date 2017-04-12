# BeeWi BBW200 reader in java
Note: as this is just a wrapper for the gatt tool, this will only work on linux.

## Prerequisites
* A linux distribution with gatttool installed
* Maven
* JDK

## Build and run
Don't forget to complete the configuration file with your hci and mac address of your sensor.

`sudo mvn clean install exec:java -Dexec.mainClass="Main"`