package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

public class HTDemo {
    public static void main(String[] args) {
        Hashtable<String, Double> balance =
                new Hashtable<>();
        Enumeration<String> names;

        String str;
        double bal;

        balance.put("Джон Доу", new Double(3434.34));
        balance.put("Том Смит", new Double(123.22));
        balance.put("Джейн Бейкер", new Double(1378.00));
        balance.put("Тод Холл", new Double(99.22));
        balance.put("Ральф Смит", new Double(-19.08));

        // показать все счета в хеш-таблице
        names = balance.keys();
        while (names.hasMoreElements()){
            str = names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();

        // внести сумму 1000 на счет Джона Доу
        bal = balance.get("Джон Доу");
        balance.put("Джон Доу", bal + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " +
                balance.get("Джон Доу"));
    }
}
