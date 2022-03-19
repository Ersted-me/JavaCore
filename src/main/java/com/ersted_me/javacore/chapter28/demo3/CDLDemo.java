package main.java.com.ersted_me.javacore.chapter28.demo3;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Запуск потока исполнения.");

        new MyThread(cdl);

        try{
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Завершение потока исполнения.");
    }
}
