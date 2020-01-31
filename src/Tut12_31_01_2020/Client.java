package Tut12_31_01_2020;

import Prog1Tools.IOTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) {
        while (true) {
            try {
                Socket s = new Socket("127.0.0.1",8080);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                bw.write(IOTools.readString("Matheaufgabe: ") + "\n");
                bw.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                System.out.println(br.readLine());
                br.close();
                bw.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
            /*
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str;
            while((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
             */