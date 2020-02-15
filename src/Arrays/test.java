package Arrays;

import Prog1Tools.IOTools;

public class test {
    public static void main(String[] args) {
        //String[] a = {"name", "bla", "blabla"};
        //String[] a = null;
        //printArray(a);

        printArray(convertArray(new boolean[]{false, true, false}, ';'));


    }

    public static String[] convertArray(boolean[] values, char separator){
        if (values == null) return null;
        String[] array = new String [values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = "Wert" + (i+1) + ": " + values[i] + separator;
        }
        return array;
    }

    public static void printArray (String[] values){
        System.out.println("{");
        if (values == null || values.length == 0){
            System.out.println("}");
            return;
        }
        int zaehler = 1;
        for (String eintrag: values) {
            System.out.println(eintrag);
        }
        System.out.println("}");
    }







}
