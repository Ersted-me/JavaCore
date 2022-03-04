package main.java.com.ersted_me.javacore.chapter22;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpCon = hp.openConnection();

        // получить дату
        long d = hpCon.getDate();
        if(d==0)
            System.out.println("Сведения о дате отсутсвтуют.");
        else
            System.out.println("Дана: " + new Date(d));

        // получить тип содержимого
        System.out.println(
                "Тип содержимого: " + hpCon.getContentType());

        // получить дату срока действия ресурса
        d = hpCon.getExpiration();
        if(d==0)
            System.out.println("Сведения о сроке действия отсутствуют.");
        else
            System.out.println("Срок действия истекает: " + new Date(d));

        // получить дату последней модификации
        d = hpCon.getLastModified();
        if(d==0)
            System.out.println("Сведения о дате последней модификации.");
        else
            System.out.println("Дана последней модификации: " + new Date(d));

        // получить длину содержимого
        long len = hpCon.getContentLengthLong();
        if(len == -1)
            System.out.println("Длина содержимого недоступна.");
        else
            System.out.println("Длина содержимого: " + len);

        if (len!=0){
            System.out.println("=== Содержимое ===");
            InputStream input = hpCon.getInputStream();
            while((c = input.read()) != -1)
                System.out.print((char) c);
            input.close();
        }else
            System.out.println("Содержимое недоступно.");
    }
}
