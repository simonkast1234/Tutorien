package SocketsTest;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 8080);
            PrintWriter bw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));) {
            String data;
            while(!(data = readConsole()).equals("quit")) {
                bw.println(data);
                bw.flush();
                System.out.println("double is: " + br.readLine());
            }
            bw.println(data);
            bw.flush();
        } catch (IOException e) {
            //
        }
    }

    public static String readConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Eingeben: (quit)");
            return br.readLine();
        } catch (IOException e) {
            //
        }
        return "";
    }


}
