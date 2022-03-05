package main.java.com.ersted_me.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;


public class StreamDemo5 {
    public static void main(String[] args) {
        // список имен, номеров телефонов и адресов электронной почты
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Джеймс", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Мэри", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        // отобразить на новый поток данных
        // только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = myList.stream()
                .map((a) -> new NamePhone(a.name, a.phonenum));

        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum);
        });
    }
}
