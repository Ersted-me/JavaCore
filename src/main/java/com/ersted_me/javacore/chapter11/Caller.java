package main.java.com.ersted_me.javacore.chapter11;

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Caller( Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}
