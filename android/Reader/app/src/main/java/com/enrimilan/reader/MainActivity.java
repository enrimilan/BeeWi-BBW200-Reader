package com.enrimilan.reader;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enrimilan.reader.model.SensorData;
import com.enrimilan.reader.reader.GattSensorReader;
import com.enrimilan.reader.reader.ISensorReader;
import com.enrimilan.reader.util.ParseUtils;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter btAdapter;
    private CircularProgressView cpv;
    private TextView errorTextView;
    private LinearLayout dataLinearLayout;
    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView batteryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.cpv = (CircularProgressView) findViewById(R.id.cpv);
        this.errorTextView = (TextView) findViewById(R.id.errorTextView);
        this.dataLinearLayout = (LinearLayout) findViewById(R.id.dataLinearLayout);
        this.temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        this.humidityTextView = (TextView) findViewById(R.id.humidityTextView);
        this.batteryTextView = (TextView) findViewById(R.id.batteryTextView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        requestBluetoothAndProceed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_ENABLE_BT) {
            if(resultCode == Activity.RESULT_OK){
                new RetrieveDataTask().execute();
            }
            else {
                showErrorMessage("Bluetooth must be enabled.");
            }
        }
    }

    private void requestBluetoothAndProceed() {
        BluetoothManager btManager = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
        if(btManager == null) {
            showErrorMessage("BluetoothManager not available.");
            return;
        }
        btAdapter = btManager.getAdapter();
        if(btAdapter == null) {
            showErrorMessage("BluetoothAdapter not available.");
            return;
        }

        if (!btAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent,REQUEST_ENABLE_BT);
        }
        else {
            new RetrieveDataTask().execute();
        }
    }

    private void showErrorMessage(String msg) {
        cpv.setVisibility(View.GONE);
        errorTextView.setText(msg);
        errorTextView.setVisibility(View.VISIBLE);
    }

    private class RetrieveDataTask extends AsyncTask<Void, Void, SensorData> {

        private String error;

        @Override
        protected SensorData doInBackground(Void... params) {
            try {
                ISensorReader sensorReader = new GattSensorReader(btAdapter, getApplicationContext());
                String[] rawData = sensorReader.readRawData();
                SensorData sensorData = ParseUtils.parseSensorData(rawData);
                System.out.println("temperature: " + sensorData.getTemperature()+"°C");
                System.out.println("humidity: " + sensorData.getHumidity() + "%");
                System.out.println("battery: " + sensorData.getBattery() + "%");
                return sensorData;
            }
            catch (RuntimeException e) {
                error = e.getMessage();
                return null;
            }

        }

        @Override
        protected void onPostExecute(SensorData sensorData) {
            if(sensorData == null) {
                showErrorMessage(error);
                return;
            }
            cpv.setVisibility(View.GONE);
            temperatureTextView.setText(sensorData.getTemperature()+"°C");
            humidityTextView.setText("humidity: " + sensorData.getHumidity() + "%");
            batteryTextView.setText("battery: " + sensorData.getBattery() + "%");
            dataLinearLayout.setVisibility(View.VISIBLE);
        }

    }
}
