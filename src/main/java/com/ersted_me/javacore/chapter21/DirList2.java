package main.java.com.ersted_me.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList2 {
    public static void main(String[] args) {
        String dirname ="\\MyDir";

        // создать фильтр, возвращающий логическое значение true
        // только в отношении доступных для записи файлов
        DirectoryStream.Filter<Path> how =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path entry) throws IOException {
                        if(Files.isWritable(entry))
                            return true;
                        return false;
                    }
                };

        // получить и использовать поток ввода из каталога
        // только доступных для записи файлов
        try(DirectoryStream<Path> dirstrm =
                    Files.newDirectoryStream(Paths.get(dirname), how)){
            System.out.println("Каталог " + dirname);

            for(Path entry: dirstrm){
                BasicFileAttributes attributes =
                        Files.readAttributes(entry, BasicFileAttributes.class);

                if(attributes.isDirectory())
                    System.out.println("<DIR> ");
                else
                    System.out.println("       ");
                System.out.println(entry.getName(1));
            }
        }catch (InvalidPathException e){
            System.out.println("Ошибка указания пути " + e);
        }catch (NotDirectoryException e){
            System.out.println(dirname + " не является каталогом.");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
