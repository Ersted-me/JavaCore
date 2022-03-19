package main.java.com.ersted_me.javacore.chapter11;

class Q {
    int n;

    synchronized int get() {
        System.out.println("Получено: " + n);
        return n;
    }

    synchronized void put(int n){
        this.n = n;
        System.out.println("Отправдено: " + n);
    }
}
