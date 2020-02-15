package Threads_Exceptions;

/**
 * 2 Möglichkeiten zum Erstellen:
 * 1) extends Thread
 * 2) implements Runnable (klassischere Weg)
 *
 * Starten von Threads immer mit .start();
 */

public class Threads extends Thread {
    public void run() {
        for (int i = 0; i < 30; i++) {
            try{
                Thread.sleep(10);
                System.out.println(this.getName() + "count: " + i);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hallo");
        System.out.println(Thread.currentThread().getName());

        Threads t = new Threads();
        Threads t1 = new Threads();
        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println("Beide sind fertig");
    }
}
