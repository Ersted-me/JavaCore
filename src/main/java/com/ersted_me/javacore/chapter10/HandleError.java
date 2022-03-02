package main.java.com.ersted_me.javacore.chapter10;

import java.util.Random;

public class HandleError {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        Random r = new Random();

        for(int i = 0; i < 32000; i++){
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = r.nextInt();
            }catch (ArithmeticException e){
                System.out.println("Деление на нуль.");
                a = 0; // присвоить нуль и продолжить работу
            }
            System.out.println("a: " + a);
        }
    }
}
