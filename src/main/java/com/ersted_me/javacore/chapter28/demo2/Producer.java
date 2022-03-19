package main.java.com.ersted_me.javacore.chapter28.demo2;

public class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) q.put(i);
    }
}
