package main.java.com.ersted_me.javacore.chapter13;

public class AssertDemo2 {
    // получить генератор случайных чисел
    static int val = 3;

    // возвратить целочисленное значение
    static int getnum(){
        return val--;
    }

    public static void main(String[] args) {
        int n =0;
        for(int i = 0;i<10;i++){
            assert (n = getnum()) > 0; // Неудачная идея!

            System.out.println("n is " + n);
        }
    }
}
