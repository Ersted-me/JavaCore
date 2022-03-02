package main.java.com.ersted_me.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;
    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        }catch (IOException e){
         return null;
        }
    }
}

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);

        try{
            while((c = input.read()) != -1)
                System.out.println((char) c);
        }catch (NullPointerException e){
            System.out.println("Ошибка открытия файла.");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }finally {
            try {
                input.close();
            }catch (IOException e){
                System.out.println("Ошибка закрытия потока ввода SequenceInputStream");
            }
        }
    }
}
