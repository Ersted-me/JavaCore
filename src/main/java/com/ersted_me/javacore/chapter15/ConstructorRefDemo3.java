package main.java.com.ersted_me.javacore.chapter15;

interface MyFunc6<R, T> {
    R func(T n);
}

// Простой обобщенный класс
class MyClass4<T> {
    private T val;
    // конструктор, принимающий один параметр
    MyClass4(T v) {
        val = v;
    }

    // Конструктор по умолчанию. Этот конструктор в
    // данной программе НЕ используется
    MyClass4() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

// Простой необобщенный класс
class MyClass7{
    String str;
    MyClass7(String s){
        str = s;
    }
    MyClass7(){
        str = "";
    }
    String getVal(){return str;}
}


public class ConstructorRefDemo3 {
    static <R,T> R myClassFactory(MyFunc6<R,T> cons, T v){
        return cons.func(v);
    }

    public static void main(String[] args) {
        // Создать ссылку на конструктор класса MyClass
        // В данном случае оператор new обращается к конструктору,
        // принимающему аргумент
        MyFunc6<MyClass4<Double>, Double> myClassCons = MyClass4<Double>::new;

        // создать экземляр типа класс MyClass, используя фабричный метод
        MyClass4<Double> mc = myClassFactory(myClassCons, 101.1);

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

        // А теперь создать экземпляр другого класса,
        // используя метод myClassFactory()
        MyFunc6<MyClass7,String> myClassCons2 = MyClass7::new;

        // создать экземпляр класса MyClass2, используя фабричный метод
        MyClass7 mc2 = myClassFactory(myClassCons2, "Лямбда");

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение str в объекте mc2 равно " + mc2.getVal());
    }
}
