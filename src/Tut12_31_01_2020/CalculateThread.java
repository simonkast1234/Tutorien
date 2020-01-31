package Tut12_31_01_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class CalculateThread implements Runnable {
    Socket client;

    public CalculateThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String calculation = br.readLine();
            String[] values = calculation.split("\\+");
            System.out.println(calculation + "=" + (Integer.parseInt(values[0]) + Integer.parseInt(values[1])));
            br.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
