package SocketsTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(8080);) {
            Socket client = s.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter bw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            int data;
            String line;
            while(!(line = br.readLine()).equals("quit")) {
                System.out.println("received: " + line);
                data = Integer.parseInt(line);
                bw.println(data*2);
                bw.flush();
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            //
        }
    }
}
