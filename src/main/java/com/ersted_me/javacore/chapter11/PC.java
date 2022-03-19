package main.java.com.ersted_me.javacore.chapter11;

class PC {
    public static void main(String[] args) {
        Q2 q = new Q2();

        new Producer(q);
        new Consumer(q);

        System.out.println("Для остановки нажмите Ctrl-C.");
    }
}
