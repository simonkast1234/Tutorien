package TEST;

public class Kindklasse extends Superklasse {
    public static void main(String[] args) {
        System.out.println(c);
        long l = 0;
        char c = '0';
        float f = 0;
        int i = 0;
        double d = 0;
        byte b = 0;

        int t = b;
        bar(l,c);
        bar(f,f);
    }

    static void bar(double a, double b) {
        System.out.println("DL");
    }
    static void bar(float... a) {
        System.out.println("FS");
    }
}
