package main.java.com.ersted_me.javacore.chapter11;

class NewThread3 implements Runnable {
    String name;
    Thread t;

    public NewThread3(String threadname) {
        name = threadname;
        // созлать новый, второй поток исполнения
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    // точка входа во второй поток исполнения
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(name + ": " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }
        System.out.println(name + " завершен.");
    }
}
