package main.java.com.ersted_me.javacore.chapter28.demo2;

import java.util.concurrent.Semaphore;

class Q {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get(){
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа InterruptedException.");
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n){
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа InterruptedException.");
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}
