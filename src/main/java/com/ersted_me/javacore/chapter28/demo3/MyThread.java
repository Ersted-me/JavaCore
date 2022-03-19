package main.java.com.ersted_me.javacore.chapter28.demo3;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable{
    CountDownLatch latch;

    MyThread(CountDownLatch c){
        latch = c;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i=0; i<5;i++){
            System.out.println(i);
            latch.countDown();
        }
    }
}
