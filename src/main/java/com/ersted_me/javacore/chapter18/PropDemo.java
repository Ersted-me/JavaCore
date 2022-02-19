package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

public class PropDemo {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтон", "Олимпия");
        capitals.put("Калифорния", "Сакраменто");
        capitals.put("Индиана", "Индианаполис");

        // получить множество ключей
        Set<?> states = capitals.keySet();

        // показать все штаты и их столицы
        for(Object name : states)
            System.out.println("Столица штата " + name + " - " +
                    capitals.getProperty((String) name) + ".");
        System.out.println();

        // найти штат, отсутствующий в списке, указав значения,
        // выбираемые по умолчанию
        String str = capitals.getProperty("Флорида", "не найдена");
        System.out.println("Сталица штата Флорида " + str + ".");
    }
}
