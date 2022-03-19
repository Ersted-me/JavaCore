package main.java.com.ersted_me.javacore.chapter11;

public class NewThread4 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread4(String name) {
        this.name = name;
        t = new Thread(this, this.name);
        System.out.println("Новый поток: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try{
            for(int i = 15; i> 0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }

        System.out.println(name + " завершен.");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}
