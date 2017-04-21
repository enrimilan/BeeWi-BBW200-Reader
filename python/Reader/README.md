# BeeWi BBW200 reader in python

## Prerequisites
* A linux distribution with gatttool installed
* Python 2.7
* Pygatt
* Nose

```
sudo pip install nose
sudo pip install pygatt
```
## Build and run
Don't forget to complete the configuration file with the mac address of your sensor.

```
nosetests test/SensorTests.py
python src/Main.py
```