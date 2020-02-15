package Threads_Exceptions;

public class TestThread extends Thread{
    ThreadSafeArray vars;

    public TestThread(ThreadSafeArray vars) {
        this.vars = vars;
    }

    public void run() {
        for (int i = 0; i < 300000; i++) {
            int index = (int) (Math.random() * 10);
            int value = (int) (Math.random() * 100);
            vars.add(value, index);
            vars.get(index);
        }
    }
}
