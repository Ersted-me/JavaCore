package main.java.com.ersted_me.javacore.chapter28.demo4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThread implements Runnable {
    CyclicBarrier cbar;
    String name;

    public MyThread(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}
