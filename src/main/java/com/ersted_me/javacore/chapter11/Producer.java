package main.java.com.ersted_me.javacore.chapter11;

class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i=0;

        while(true){
            q.put(i++);
        }
    }
}
