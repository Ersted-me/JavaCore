package main.java.com.ersted_me.javacore.chapter28.demo10;

import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            System.out.println("Поток " + name + " ожидает блокировки счетчика.");
            lock.lock();
            System.out.println("Поток " + name + " блокирует счетчик.");
            Shared.count++;
            System.out.println("Поток " + name + " ожидает.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }finally {
            System.out.println("Поток " + name + " разблокирует счетчик.");
            lock.unlock();
        }
    }
}
