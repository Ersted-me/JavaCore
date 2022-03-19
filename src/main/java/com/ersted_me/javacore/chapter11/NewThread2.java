package main.java.com.ersted_me.javacore.chapter11;

public class NewThread2 extends Thread {
    public NewThread2() {
        // созлать новый, второй поток исполнения
        super("Демонстрационный поток");
        System.out.println("Дочерний поток: " + this);
        start();
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
