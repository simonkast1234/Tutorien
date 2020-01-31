package Tut12_31_01_2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            int erg = Integer.parseInt(values[0]) + Integer.parseInt(values[1]);
            System.out.println(calculation + "=" + erg);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write("Dein Ergebnis ist " + erg + "\n");
            bw.flush();
            br.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 while((calculation = br.readLine()) != null) {
 String[] values = calculation.split("\\+");
 System.out.println(calculation + "=" + (Integer.parseInt(values[0]) + Integer.parseInt(values[1])));
 }
 **/