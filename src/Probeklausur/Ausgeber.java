package Probeklausur;

public class Ausgeber implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i+=4) {
            if(i == 40) continue;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Thread(new Ausgeber()).start();
    }


}
