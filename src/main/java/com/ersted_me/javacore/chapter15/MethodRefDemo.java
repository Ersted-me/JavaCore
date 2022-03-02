package main.java.com.ersted_me.javacore.chapter15;
// В этом классе определяется статический метод strReverse()
class MyStringOps{
    // Статический метод, изменяющий порядок
    // следования символов в строке
    static String strReverse(String str){
        String result = "";
        int i;

        for(i = str.length() - 1; i >=0; i--)
            result += str.charAt(i);

        return result;
    }
}
public class MethodRefDemo {
    // Первый параметр этого метода имеет тип функционального
    // интерфейса. Следовательно, ему можно перевать ссылку на
    // любой экземпляр этого интерфейса, включая экземаляр,
    // создаваемый в лямбда-выражении. А второй параметр
    // обозначает обрабатываемую символьную строку
    static String stringOp(StringFunc sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражение повышают эффективность Java";
        String outStr;

        // Здесь ссылка на метод strReverse() передается методу stringOp()
        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Исходящая строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);

    }
}
