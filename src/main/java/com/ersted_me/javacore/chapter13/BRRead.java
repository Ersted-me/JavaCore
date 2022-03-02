package main.java.com.ersted_me.javacore.chapter13;

import java.io.*;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введите символы, 'q' - для выхода.");
        // читать символы
        do{
            c = (char) br.read();
            System.out.println(c);
        }while (c != 'q');
    }
}
