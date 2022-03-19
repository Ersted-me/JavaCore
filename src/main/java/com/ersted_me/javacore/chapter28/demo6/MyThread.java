package main.java.com.ersted_me.javacore.chapter28.demo6;

import java.util.concurrent.Phaser;

class MyThread implements Runnable {
    Phaser phsr;
    String name;

    public MyThread(Phaser phsr, String name) {
        this.phsr = phsr;
        this.name = name;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " начинает первую фазу.");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает вторую фазу.");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу.");
        phsr.arriveAndDeregister();
    }
}
