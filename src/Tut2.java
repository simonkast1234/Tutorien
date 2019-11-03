import Prog1Tools.IOTools;

/*
Heute:
Methoden Grundlagen
rekursive Funktionen
bubblesort
mehrdimensionale Arrays
 */

public class Tut2 {
    public static void main(String[] args) {
        //a13();
        //a22();
        //boolean t = testPrime(IOTools.readInt("Zahl eingeben: "));
        //System.out.println(t);
        // mehrDimArray();
        // a21();
    }

    public static void mehrDimArray(){
        int[] a = new int [4];
        int[][][] b = new int[8][4][5];

        int [][] schachbrett = new int [8][8]; // Spalten x Zeilen) 2 dim array initialisieren

        for (int i = 0; i < schachbrett.length; i++) { // i-te Zeile in der wir sind (Spaltendurchgang)
            for (int j = 0; j < schachbrett[i].length; j++) { // j-te Spalte (Zeilendurchgang)
                schachbrett[i][j] = (i+1)+j; // Spaltennummer + 1 + Zeilennummer
            }
        }
        print2Dim(schachbrett);
    }

    public static void print2Dim(int[][] array){
        for (int i = 0; i < array.length; i++) { // durchläuft Spalte
            for (int j = 0; j < array[i].length; j++) { // durchläuft die Zeile
                System.out.print(array[i][j]+" ");  // printen alle Zeilenwerte
            }
            System.out.println(); // Nachdem wir die Zeile gedruckt haben, nächste Zeile
        }
    }

    public static void a21(){ // Zum Sortieren "bubblesort"
        int a = IOTools.readInt("Wie viele Zahlen willst du sortieren? ");
        int counter = 0;
        int[] werte = new int[a];

        for (int i: werte) {
            werte[counter] = IOTools.readInt((counter+1)+ ". Zahl ist: ");
            counter ++;
        }

        print(werte); // Vorher Werte ausgeben
        System.out.println();

        // Sortieralgorithmus
        for (int i = 0; i < werte.length; i++) { //Wir gehen a mal durdch das array, damit wir jeden Wert vergleichen

            for (int j = 1; j < werte.length - i; j++) { // so oft durch array, wie es unsortierte elemente gibt

                if(werte[j-1]>werte[j]){ // vergleich aktuelles paerchen mit vorherigem
                    int tmp = werte[j-1]; // Tausch
                    werte[j-1] = werte[j];
                    werte[j] = tmp;
                }
            }
        }
        print(werte);
    }

    public static void print(int[] array){ // eindim Array printen in eine Zeile
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void print(int[] array, int counter){ //rekursives Printen
        if(counter == array.length){
            return;
        }
        else{
            System.out.println(array[counter++]);
            print(array, counter); // rekursionsaufruf !
        }
    }

    public static void a13(){ // rechte Haelfte Tannenbaum
        int a = IOTools.readInt("Anzahl der Zeilen: ");

        for (int i = 1; i <= a ; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void a22(){ // ganzer Tannenbaum
        int a = IOTools.readInt("Anzahl der Zeilen: ");

        for (int i = 1; i <= a; i++) {
            for (int j = a -i; j != 0; j--) { // Leerzeichen setzen
                System.out.print(" ");
            }
            for (int j = 2*i-1; j != 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= a-1; i++) {
            System.out.print(" ");
        }
        System.out.print("I");
        System.out.println();
    }

    public static boolean testPrime(int zahl){
        for (int i = 2; i < zahl ; i++) {
            if(zahl % i == 0) {
                return false;
            }
        }
        return true;
    }

}
