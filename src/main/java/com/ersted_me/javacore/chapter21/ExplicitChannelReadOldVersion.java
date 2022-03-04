package main.java.com.ersted_me.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelReadOldVersion {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;

        try{
            // сначала открыть файл для ввода
            fIn = new FileInputStream("test.txt");

            // затем получить канал к этому файлу
            fChan = fIn.getChannel();

            // выделить оперативную память под буфер
            mBuf = ByteBuffer.allocate(128);

            do{
                // читать данные в буфер
                count = fChan.read(mBuf);

                // прекратить чтение по дистижении конца файла
                if(count != -1){

                    // подготовить буфер к чтению из него
                    mBuf.rewind();

                    // читать байты данных из буфера и
                    // выводить их на экран как символы
                    for (int i = 0; i < count; i++)
                        System.out.println((char) mBuf.get());
                }
            }while (count != -1);
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
