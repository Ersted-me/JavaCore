package main.java.com.ersted_me.javacore.chapter11;

class Caller2 implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Caller2( Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target){
            target.call(msg);
        }
    }
}