package reader;

import exception.ProcessCallException;
import util.ParseUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple java wrapper for gatt tool
 */
public class GattToolSensorReader implements ISensorReader {

    private String hci;
    private String mac;

    public GattToolSensorReader() {
        this.hci = ParseUtils.getProperties().getProperty("hci");
        this.mac = ParseUtils.getProperties().getProperty("mac");
    }

    @Override
    public String readRawData() {
        try {
            startOrStopHCI("down");
            startOrStopHCI("up");
            ProcessBuilder processBuilder = new ProcessBuilder("gatttool", "-i", hci, "-b", mac, "--char-read", "--handle=0x003f");
            Process p = processBuilder.start();
            p.waitFor();
            checkForErrors(p);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String rawData = br.readLine();
            return rawData;
        } catch (InterruptedException | IOException e) {
            throw new ProcessCallException(e);
        }
    }

    private void startOrStopHCI(String command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("hciconfig", hci, command);
        Process p = processBuilder.start();
        p.waitFor();
        checkForErrors(p);
        Thread.sleep(50);
    }

    private void checkForErrors(Process p) throws IOException {
        if(p.exitValue() != 0) {
            String error = "";
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String s;
            while ((s = bf.readLine()) != null) {
                error = error + s;
            }
            throw new ProcessCallException(error);
        }
    }
}
