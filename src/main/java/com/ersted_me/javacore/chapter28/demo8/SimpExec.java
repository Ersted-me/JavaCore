package main.java.com.ersted_me.javacore.chapter28.demo8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SimpExec {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков.");

        es.execute(new MyThread("A", cdl));
        es.execute(new MyThread("B", cdl2));
        es.execute(new MyThread("C", cdl3));
        es.execute(new MyThread("D", cdl4));

        try {
            cdl.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        es.shutdown();
        System.out.println("Завершение потоков.");
    }
}