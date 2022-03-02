package main.java.com.ersted_me.javacore.chapter10;

public class MultipleCatches {
    public static void main(String[] args) {
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[] = {1};
            c[42] = 99;
        }catch (ArithmeticException e){
            System.out.println("Деление на нуль: " + e);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка индексации за пределаами массива: " + e);
        }
        System.out.println("После блока операторов try/catch.");

    }
}
