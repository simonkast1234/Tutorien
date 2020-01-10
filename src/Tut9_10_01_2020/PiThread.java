package Tut9_10_01_2020;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class PiThread implements Runnable {
    int times;
    int simulatedHits;

    public PiThread(int times, int simulatedHits) {
        this.times = times;
        this.simulatedHits = simulatedHits;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < this.times; i++) {
            double hits = 0;
            for (int j = 0; j < this.simulatedHits; j++) {
                double x = r.nextFloat();
                double y = r.nextFloat();
                if(x*x+y*y <= 1) {
                    hits++;
                }
            }
            System.out.println(4*hits/this.simulatedHits);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[16];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new PiThread(100, 1000000));
        }
        long time = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Time needed: " + (System.currentTimeMillis() - time) + " ms");
    }

}
