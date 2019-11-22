package Tut4_22_11_2019;

import Prog1Tools.IOTools;

import java.util.Arrays;

public class HangmanGame {

    char[] randomWord;
    int versuche;
    String versuchsBuchstaben;
    String gefundeneBuchstaben;
    int fehler;

    /*
    public HangmanGame(char[] randomWord, int versuche, char[] versuchsBuchstaben){
        this.randomWord = randomWord;
        this.versuche = versuche;
        this.versuchsBuchstaben = versuchsBuchstaben;
    }
    */

    public HangmanGame(){
        this.randomWord = RandomWord.getRandomWord().toCharArray(); // "Klassenmethoden" = Kann man immer aufrufen
        this.versuche = 0;
        this.versuchsBuchstaben = "";
        this.gefundeneBuchstaben = "";
        this.fehler = 0;
    }

    private boolean checkWin(){
        String s = new String(this.randomWord);
        char[] gefundeneBuchstaben = this.gefundeneBuchstaben.toCharArray();
        for (int i = 0; i < gefundeneBuchstaben.length; i++) {
            s = s.replaceAll("" + gefundeneBuchstaben[i], "");
        }
        return s.equals("");
    }

    private void printUnderscores(){ // auf private kann nur innerhalb der Klasse zugegriffen werden
        for (int i = 0; i < this.randomWord.length; i++) {
            if(this.gefundeneBuchstaben.contains(""+this.randomWord[i])){ //Prüfen, ob Buchstabe schon gefunden
                System.out.print(this.randomWord[i]+" ");
            } else{
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private void charEinlesen(){
        char newBuchstabe = IOTools.readChar("Deine Eingabe: ");
        if(this.versuchsBuchstaben.contains("" + newBuchstabe)){
            System.out.println("Den Buchstaben hattest du schon.");
            charEinlesen();
        } else{
            this.versuchsBuchstaben += newBuchstabe;
            this.versuche ++;
            for (int i = 0; i < this.randomWord.length; i++) {
                if(this.randomWord[i] == newBuchstabe){
                    this.gefundeneBuchstaben += newBuchstabe;
                    System.out.println("Du hast einen neuen Buchstaben gefunden!");
                    return;
                }
            }
            System.out.println("Du hast leider keinen neuen Buchstaben gefunden!");
            this.fehler++;
        }
    }

    private void printLappen(){
        switch (this.fehler){
            case 11: System.out.println("------");
            case 10: System.out.println("------");
            case 9: System.out.println("------");
            case 8: System.out.println("------");
            case 7: System.out.println("------");
            case 6: System.out.println("------");
            case 5: System.out.println("------");
            case 4: System.out.println("------");
            case 3: System.out.println("------");
            case 2: System.out.println("------");
            case 1: System.out.println("------"); break;
        }
    }

    public void start(){
        while(true) {
            if(this.fehler == 11){
                System.out.println("Du hast verloren! Dein Wort war: " + new String(this.randomWord));
                return;
            }

            if(checkWin()){
                System.out.println("Du hast gewonnen!");
                return;
            }
            System.out.println(this.versuche + ". Versuch: ");
            printUnderscores();
            charEinlesen();
        }
    }

    public static void main(String[] args) {
        HangmanGame myGame = new HangmanGame();
        myGame.start();

    }





}
