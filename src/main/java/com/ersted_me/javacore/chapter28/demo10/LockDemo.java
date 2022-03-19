package main.java.com.ersted_me.javacore.chapter28.demo10;

import java.util.concurrent.locks.ReentrantLock;

class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread("A", lock);
        new LockThread("B", lock);
    }
}
