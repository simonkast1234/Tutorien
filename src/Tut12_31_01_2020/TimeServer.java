/**
 * Socket dient als Connector, damit wir über das Netzwerk
 * kommunizieren können. Zugriff über Input- und Output-
 * Streams.
 */

package Tut12_31_01_2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class TimeServer {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8080);
            while(true) {
                Socket client = s.accept();
                new Thread(new CalculateThread(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            return s;
        } catch (Exception e) {
            return "";
        }
    }

}
