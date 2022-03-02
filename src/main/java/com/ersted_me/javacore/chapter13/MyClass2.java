package main.java.com.ersted_me.javacore.chapter13;

public class MyClass2 {
    int a;
    int b;

    // инициализировать поля a и b по отдельности
    MyClass2(int i, int j) {
        a = i;
        b = j;
    }

    // инициализировать поля a и b одним и тем же значением
    MyClass2(int i) {
        this(i,i);
    }

    // присвоить полям a и b нулевое значение по умолчанию
    MyClass2() {
        this(0);
    }
}
