package main.java.com.ersted_me.javacore.chapter28.demo2;

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for(int i=0; i<20;i++) q.get();
    }
}
