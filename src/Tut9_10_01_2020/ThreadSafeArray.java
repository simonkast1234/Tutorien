package Tut9_10_01_2020;

/**
 * HIER: synchronised block
 *
 * synchronised in Methodenkopf = synchronised(this)
 */

public class ThreadSafeArray {

    int[] vars = new int[10];

    public void add(int value, int index) {
        //synchronized (vars) { // in diesem Bereich darf sich nur ein Thread aufhalten!
            vars[index] = value;
        //}

    }

    public int get(int index) {
        synchronized (vars) {
            return vars[index];
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadSafeArray ts = new ThreadSafeArray();
        Thread t1 = new TestThread(ts);
        Thread t2 = new TestThread(ts);
        Thread t3 = new TestThread(ts);
        Thread t4 = new TestThread(ts);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        for(int i : ts.vars) {
            System.out.print(i+",");
        }
    }
}
