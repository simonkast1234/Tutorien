package Arrays;

import Prog1Tools.IOTools;

public class Tut3_06_11_2019 {
    /**
     * Heute nur Wiederholung des imperativen Blocks
     * @param args
     *
     * foreach:
     * for (typ name : durchzugehendes Array){
     *     do(name);
     * }
     */
    public static void main(String[] args) {
        double[] arr = readArray(4);
        double[] positiv = subset(arr, 1.0);
        double[] negativ = subset(arr, -1.0);

        double[][] joint = join(positiv, negativ);
        for (double[] doubles : joint) {
            print(doubles);
        }
    }

    //1.1
    public static double[] readArray(int anzahl){
        if (anzahl < 0) return null;
        double[] array = new double[anzahl];
        for (int i = 0; i < anzahl; i++) {
            array[i] = IOTools.readDouble( i+1 +". double Werte eingeben: ");
        }
        return array;
    }

    //gegeben
    public static double[][] join (double[] first, double[] second){
        return new double[][] {first, second};
    }

    //1.2
    public static int count(double[] reihe, double faktor){
        if (reihe == null) return -1;
        int i = 0;
        int counter = 0;
        while(i < reihe.length){
            if ((faktor * reihe[i]) <= 0) counter++;
            i++;
        }
        return counter;
    }

    //1.3
    public static double[] subset(double[] zahlen, double faktor){
        if (zahlen == null) return null;
        double[] ergebnis = new double[count(zahlen, faktor)];
        int zaehler = 0;

        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] * faktor >= 0){
                ergebnis[zaehler] = zahlen[i];
                zaehler++;
            }
        }
        return ergebnis;
    }

    //1.4 ///hier nochmal mit Break oder return statt else testen...
    public static void print(double[] zahlen){
        if (zahlen == null || zahlen.length == 0){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + ", ");
        }
        System.out.println("]");
    }
}
