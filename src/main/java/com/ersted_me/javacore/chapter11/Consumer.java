package main.java.com.ersted_me.javacore.chapter11;

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "потребитель").start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}
