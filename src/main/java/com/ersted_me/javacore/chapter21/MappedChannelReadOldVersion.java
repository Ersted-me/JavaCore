package main.java.com.ersted_me.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelReadOldVersion {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        long fSize;
        MappedByteBuffer mBuf;

        try{
            // сначала открыть файл для ввода
            fIn = new FileInputStream("test.txt");

            // затем получить канал к этому файлу
            fChan = fIn.getChannel();

            // получить размер файла
            fSize = fChan.size();

            // а теперь сопоставить файл с буфером
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0,fSize);

            // читать байты данных из буфера и
            // выводить их на экран как символы
            for (int i = 0; i < fSize; i++)
                System.out.println((char) mBuf.get());

        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }finally {
            try{
                if(fChan != null) fChan.close(); // закрыть канал
            }catch (IOException e){
                System.out.println("Ошибка закрытия канала.");
            }
            try {
                if(fIn != null) fIn.close(); // закрыть файл
            }catch (IOException e){
                System.out.println("Ошибка закрытия файла.");
            }
        }
    }
}
