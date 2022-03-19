package main.java.com.ersted_me.javacore.chapter28.demo7;

import java.util.concurrent.Phaser;

class MyThread implements Runnable {
    Phaser phaser;
    String name;

    public MyThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()){
            System.out.println("Поток " + name + " начинает фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
