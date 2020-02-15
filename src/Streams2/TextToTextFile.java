/**
 * FileWriter character-weise
 * Print-Writer zeilenweise
 * InputStreamReader macht aus bits chars
 */

package Streams2;

import java.io.*;

public class TextToTextFile {

    /* // Mit PrintWriter
    public static void main(String[] args) {
        int zeilen = IOTools.readInt("Anzahl der Zeilen: ");

        try(PrintWriter pr = new PrintWriter(new FileWriter("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/text.txt"))) {
            for (int i = 0; i < zeilen; i++) {
                pr.println(readConsole());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
     */

    /* // Mit BufferedWriter
    public static void main(String[] args) {
        int zeilen = IOTools.readInt("Anzahl der Zeilen: ");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/text.txt"))) {
            for (int i = 0; i < zeilen; i++) {
                bw.write(readConsole() + "\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
     */
    /* // Jeden 2. char schreiben
    public static void main(String[] args) {
        int zeilen = IOTools.readInt("Anzahl der Zeilen: ");

        try(FileWriter fw = new FileWriter("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/text.txt")) {
            for (int i = 0; i < zeilen; i++) {
                char[] Arrays.test = readConsole().toCharArray();
                for (int j = 0; j < Arrays.test.length; j += 2) {
                    fw.append(Arrays.test[j]);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
     */

    public static String readConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            br.close();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
