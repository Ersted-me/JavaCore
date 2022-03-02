package main.java.com.ersted_me.javacore.chapter15;
interface MyFunc5<T>{
    MyClass3<T> func(T n);
}

class MyClass3<T>{
    private T val;

    MyClass3(T v) {
        val = v;
    }

    MyClass3(){val = null;}
    T getValue(){return val;}
}
public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        // создать ссылку на конструктор обобщенного класса MyClass<T>
        MyFunc5<Integer> myClassCons = MyClass3<Integer>::new;

        // создать экземпляр класса MyClass<T>
        // по данной ссылке на конструктор
        MyClass3<Integer> mc = myClassCons.func(100);

        // воспользоваться только что созданным
        // экземпляром класса MyClass<T>
        System.out.println(
                "Значение val в объекте mc равно " + mc.getValue());
    }
}
