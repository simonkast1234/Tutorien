public class test {
    public static void main(String[] args) {
        int[] zahlen = new int [] {1,2,3,4,5};
        //zahlen = new int[] {1,2,3,4,5};


        /*
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i + 1;
        }
        */

        for (int wert : zahlen) {
            System.out.println(wert);
        }
    }
}
