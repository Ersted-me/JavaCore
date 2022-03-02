package main.java.com.ersted_me.javacore.chapter10;

public class ThrowsDemo {
    static void trowOne() throws IllegalAccessException{
        System.out.println("В теле метода trowOne().");
        throw new IllegalAccessException("демонстрация");
    }

    public static void main(String[] args) {
        try {
            trowOne();
        }catch (IllegalAccessException e){
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
