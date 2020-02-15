package Streams1;

import Prog1Tools.IOTools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAXIMUM_ERRORS = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Tut6_02_12_2019/words2.txt")); // Main.class.getResource("words.txt")
        String ln;
        List<String> wordsList = new ArrayList<>();
        while ((ln = reader.readLine()) != null) {
            wordsList.add(ln);
        }
        String[] words = wordsList.toArray(new String[0]);


        char[] word = selectRandom(words).toCharArray();
        boolean[] guessed = new boolean[word.length];
        int errors = 0;

        while(!isTrue(guessed)) {

            // Wort ausgeben
            for (int i = 0; i < word.length; i++) {
                if(guessed[i]) {
                    System.out.print(word[i] + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println("\n");

            // Buchstaben einlesen
            char c = IOTools.readChar("Buchstaben eingeben: ");
            boolean attemptSuccessful = false;
            for (int i = 0; i < word.length; i++) {
                if(word[i] == c) {
                    guessed[i] = true;
                    attemptSuccessful = true;
                }
            }

            if(attemptSuccessful) {
                System.out.println("Richtig geraten");
            } else {
                System.out.println("Falsch geraten!");
                errors++;
                System.out.println("Übrige Versuche: " + (MAXIMUM_ERRORS - errors));
            }

            if(errors >= MAXIMUM_ERRORS) {
                System.out.println("Verloren!" +"\n" + "Das Wort war " + new String(word));
                return;
            }
        } // while

    }

    private static boolean isTrue(boolean[] guessed) { // unschön mit static zu arbeiten ...
        for (int i = 0; i < guessed.length; i++) {
            if(!guessed[i]) {
                return false;
            }
        }
        return true;
    }

    public static String selectRandom(String[] words){
        int index = (int) (words.length * Math.random());
        return words[index];
    }





}
