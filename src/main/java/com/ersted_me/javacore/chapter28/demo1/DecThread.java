package main.java.com.ersted_me.javacore.chapter28.demo1;

import java.util.concurrent.Semaphore;

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    public DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока: " + name);

        try {
            System.out.println("Поток " + name + " ожидает разрешения.");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение.");

            for(int i=0;i<5;i++){
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " освобождает разрешение.");
        sem.release();
    }
}
