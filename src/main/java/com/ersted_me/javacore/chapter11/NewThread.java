package main.java.com.ersted_me.javacore.chapter11;

class NewThread implements Runnable {
    Thread t;

    public NewThread() {
        // созлать новый, второй поток исполнения
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дочерний поток: " + t);
        t.start();
    }

    // точка входа во второй поток исполнения
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Дочерний поток: " + n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }
}
