package main.java.com.ersted_me.javacore.chapter28.demo1;

import java.util.concurrent.Semaphore;

class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread("A",sem);
        new DecThread("B",sem);
    }
}
