package Streams2;

import java.io.*;

public class CopyText {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/text.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/text2.txt"))) {
            String s;
            while((s = br.readLine()) != null) {
                pw.println(s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
