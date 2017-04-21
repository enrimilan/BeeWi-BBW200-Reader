package com.enrimilan.reader.reader;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

import java.util.UUID;

public class BeeWiSmartBtCallback extends BluetoothGattCallback {

    private static final String SERVICE_UUID = "a8b3fa04-4834-4051-89d0-3de95cddd318";
    private static final String CHARACTERISTIC_UUID = "a8b3fb43-4834-4051-89d0-3de95cddd318";
    private String[] data;
    private final Object synchObj;

    public BeeWiSmartBtCallback(String[] data, Object synchObj) {
        this.data = data;
        this.synchObj = synchObj;
    }

    @Override
    public void onConnectionStateChange(final BluetoothGatt gatt, final int status, final int newState) {
        gatt.discoverServices();
    }

    @Override
    public void onServicesDiscovered(final BluetoothGatt gatt, final int status) {
        BluetoothGattService service = gatt.getService(UUID.fromString(SERVICE_UUID));
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(CHARACTERISTIC_UUID));
        gatt.readCharacteristic(characteristic);
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        System.out.println("raw data:");
        byte[] bytes = characteristic.getValue();
        for(int i=0; i<bytes.length; i++) {
            data[i] = String.format("%02X", bytes[i]);
            System.out.print(data[i] + " ");
        }
        System.out.println();
        gatt.disconnect();
        synchronized (synchObj) {
            synchObj.notify();
        }
    }

}
