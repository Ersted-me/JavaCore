package main.java.com.ersted_me.javacore.chapter28.demo2;

public class ProdCon {
    public static void main(String[] args) {
        Q q = new Q();

        new Producer(q);
        new Consumer(q);
    }
}
