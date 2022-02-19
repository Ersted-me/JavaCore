package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

// Компаратор сравнивающий фамилии вкладчиков
class CompLastName implements Comparator<String>{
    public int compare(String aStr, String bStr) {
        int i, j;

        // найти индекс символа, с которого начинается фамилия
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

// отсартировать счета вкладчиков по Ф.И.О., если фамилии одинаковы
class CompThenByFirstName implements Comparator<String>{
    public int compare(String aStr, String bStr) {
        return aStr.compareToIgnoreCase(bStr);
    }
}

public class TreeMapDemo2A {
    public static void main(String[] args) {
        // использовать метод thenComparing() для создания
        // компаратора, сравнивающего сначала фамилии, а затем
        // ФИО вкладчиков, если фамилии одинаковы
        CompLastName compLN = new CompLastName();
        Comparator<String> compLastThenFirst =
                compLN.thenComparing(new CompThenByFirstName());

        // создать хеш-отображение
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);

        // ввести элементы в хеш-отображение
        tm.put("Джон Доу", new Double(3434.34));
        tm.put("Том Смит", new Double(123.22));
        tm.put("Джейн Бейкер", new Double(1378.00));
        tm.put("Тод Холл", new Double(99.22));
        tm.put("Ральф Смит", new Double(-19.08));

        // получить множество записей
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // вывести множество записей
        for(Map.Entry<String, Double> me : set){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // внести сумму 1000 на счет Джона Доу
        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " +
                tm.get("Джон Доу"));
    }
}
