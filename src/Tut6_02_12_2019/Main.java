package Tut6_02_12_2019;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader()); // Main.class.getResource("words.txt")

        String ln;
        List<String> wordsList = new ArrayList<>();
        while ((ln = reader.readLine()) != null) {
            wordsList.add(ln);
        }
        String[] words = wordsList.toArray(new String[0]);

        String word = selectRandom(words);
        boolean[] guessed = new boolean[word.length()];

        System.out.println(word);

    }

    public static String selectRandom(String[] words){
        int index = (int) (words.length * Math.random());
        return words[index];
    }





}
