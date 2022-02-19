package main.java.com.ersted_me.javacore.chapter18;

import java.util.*;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // создать двухсторонюю очередь
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // использовать класс ArrayDeque для организации стека
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Извлечение из стека: ");

        while(adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();
    }
}
