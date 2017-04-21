import pygatt
import sys
import os.path

sys.path.append(os.path.join(os.path.dirname(__file__), '..'))
from utils.Constants import CHARACTERISTIC_UUID
from utils.Constants import MAC_ADDRESS

class GattSensorReader():

    def readRawData(self):
        if(MAC_ADDRESS == ""):
            raise ValueError('Mac address missing in Constants.py')

        adapter = pygatt.GATTToolBackend()
        adapter.start()
        device = adapter.connect(MAC_ADDRESS, 15)
        value = device.char_read(CHARACTERISTIC_UUID)
        return ''.join('{:02x} '.format(x) for x in value)