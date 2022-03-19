package main.java.com.ersted_me.javacore.chapter28.demo11;

class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}
