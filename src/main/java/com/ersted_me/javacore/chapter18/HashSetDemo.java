package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        // создать хеш-множество
        HashSet<String> hs = new HashSet<String>();

        // ввестии элементы в хеш-множество
        hs.add("Бета");
        hs.add("Альфа");
        hs.add("Эта");
        hs.add("Гамма");
        hs.add("Эпсилон");
        hs.add("Омега");

        System.out.println(hs);
    }
}
