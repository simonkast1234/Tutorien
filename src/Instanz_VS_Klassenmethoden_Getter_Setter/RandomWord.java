package Instanz_VS_Klassenmethoden_Getter_Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class RandomWord {

    public static String getRandomWord(){
        try {
            URL path = RandomWord.class.getResource("words.txt");
            File f = new File(path.getFile());
            BufferedReader br = new BufferedReader(new FileReader(f));
            int rnd = (int) (1+ (Math.random()*685616));
            for (int i = 0; i < rnd; i++) {
                br.readLine();
            }
            return br.readLine().toLowerCase();
        }catch (Exception e){
            return "-1";
        }
    }

    public static void main(String[] args) {
        System.out.println(getRandomWord());
    }
}
