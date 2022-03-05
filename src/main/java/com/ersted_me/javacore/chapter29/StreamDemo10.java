package main.java.com.ersted_me.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        // создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        // получить поток данных для списочного массива
        Stream<String> myStream = myList.stream();

        // получить итератор-разделитель для потока данных
        Spliterator<String> spltItr = myStream.spliterator();

        // а теперь разделить первый итератор
        Spliterator<String> splitItr2 = spltItr.trySplit();

        // использовать сначала итератор splitItr2, если
        // нельзя разделить итератор splitItr
        if(splitItr2 != null){
            System.out.println("Результат, выводимый итератором splitItr2: ");
            splitItr2.forEachRemaining((n) -> System.out.println(n));
        }

        // а теперь воспользоваться итератором splitItr
        System.out.println("\nРезультат, выводимый итератором splitItr: ");
        spltItr.forEachRemaining((n) -> System.out.println(n));
    }
}
