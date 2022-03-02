package main.java.com.ersted_me.javacore.chapter15;

interface MyFunc4 {
    MyClass2 func(int n);
}

class MyClass2 {
    private int val;

    MyClass2(int v) {
        val = v;
    }

    MyClass2() {
        val = 0;
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // создать ссылку на конструктор класса MyClass.
        // Метод func() из интерфейса MyFunc принимает аргумент,
        // поэтому оператор new обращается к парамметризированному
        // конструктору класса MyClass, а не к его конструктору по умолчанию
        MyFunc4 myClassCons = MyClass2::new;

        // создать экземпляр класса MyClass по ссылке на его конструктор
        MyClass2 mc = myClassCons.func(100);

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}
