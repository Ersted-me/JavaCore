package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

public class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();
        defList.put("Флорида", "Тэллеси");
        defList.put("Висконсин", "Мэдисон");

        Properties capitals = new Properties(defList);
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

        // теперь штат Флорида будет найден в списке по умолчанию
        String str = capitals.getProperty("Флорида");
        System.out.println("Сталица штата Флорида " + str + ".");
    }
}
