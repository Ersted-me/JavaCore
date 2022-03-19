package main.java.com.ersted_me.javacore.chapter11;

public class ExtendThread {
    public static void main(String[] args) {
        new NewThread2();

        try {
            for(int n =5; n>0; n--){
                System.out.println("Главный поток: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток исполнения прерван");
        }
        System.out.println("Главный поток завершен.");
    }
}
