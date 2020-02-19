package Socket;

import Prog1Tools.IOTools;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try(Socket s = new Socket("localhost",8080);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));) {

            for (int i = 0; i < 10; i++) {
                bw.write(IOTools.readString("Matheaufgabe: ") + "\n");
                bw.flush();
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
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