/**
 * producerConsumer Problem: Mehrere Threads greifen auf dieselben Ressourcen zu
 * Achtung: sleep() oder wait() wirft immer eine interruptedException wenn notified
 *          -> also handlen (try-catch oder hochwerfen)
 * wait(), sleep() etc in diesem Fall immer im synchronised block, damit klar ist, welcher Thread schlafen muss.
 * wait() gibt das lock frei, deshalb auch nur im synchronised block
 * sleep() geht auch außerhalb von synchronised
 * notify() wird ein random thread geweckt
 */

package Tut10_17_01_2020;

import java.util.Random;

public class ThreadSafeArray {
    int[] arr;
    int index;
    boolean rising = true;
    public ThreadSafeArray(int size) {
        this.arr = new int[size];
        this.index = 0;
    }

    public void produce() throws InterruptedException {
        int r = new Random().nextInt();
        synchronized (this) { // könnte auch (this)/(arr) nehmen, dann wäre das ganze objekt gesperrt
            while(!rising) { // Schleife, falls einfügen aufgrund ArrayOutOfBounds nicht passiert
                wait(); // hier warten, bis notified . WENN DAS HIER, DANN IMMER INTERRUPTED EXCEPTION WERFEN
            }
            System.out.println(Thread.currentThread().getName() + " produced " + r);
            arr[index++] = r;
            notifyAll(); // alle aufwecken, damit consumer weiß, dass es weitergehen kann
            if(index == arr.length) this.rising = false;
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while(rising) {
                wait();
            }
            int toRead = this.arr[0];
            for (int i = 1; i < this.arr.length; i++) { // nach vorne verschieben
                this.arr[i-1] = this.arr[i];
            }
            this.index--;
            System.out.println(Thread.currentThread().getName() + " consumed " + toRead);
            notifyAll();
            if(index == 0) this.rising = true;
        }
    }

    public static void main(String[] args) {
        ThreadSafeArray arr = new ThreadSafeArray(20);
        new Thread(new ProduceThread(arr)).start(); // runnable
        new ConsumeThread(arr).start(); // thread
        new Thread(new ProduceThread(arr)).start(); // runnable
        new ConsumeThread(arr).start(); // thread
    }
}
