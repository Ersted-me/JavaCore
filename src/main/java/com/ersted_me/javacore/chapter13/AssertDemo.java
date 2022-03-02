package main.java.com.ersted_me.javacore.chapter13;

public class AssertDemo {
    static int val = 3;

    // возвратит целочисленное значение
    static int getnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;

        for (int i = 0; i < 10; i++) {
            n = getnum();
            assert n > 0; // не подтвердится, если n==0

            System.out.println("n равно " + n);
        }
    }
}
