package main.java.com.ersted_me.javacore.chapter15;

// В этом классе определяется статический метод strReverse()
class MyStringOps2 {
    // Статический метод, изменяющий порядок
    // следования символов в строке
    String strReverse(String str) {
        String result = "";
        int i;

        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }
}

public class MethodRefDemo2 {

    // В этом методе функциональный интерфейс указывается в качестве
    // типа первого его параметра. Следовательно, ему модет быть передан
    // любой экземпляр этого интерфейса, включая ссылку на метод
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражение повышают эффективность Java";
        String outStr;

        // создать объект типа MyStringOps
        MyStringOps2 strOps = new MyStringOps2();

        // А теперь ссылка на метод экземпляра strReverse()
        // передается методу stringOps()
        outStr = stringOp(strOps::strReverse, inStr);

        System.out.println("Исходящая строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
