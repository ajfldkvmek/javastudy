package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *  이런 기능 위주의 클래스는 다 외우는 것이 아니라
 *  이런게 있다 정도만 기억해두고 필요할 때 마다 찾아보는 것이다
 *  Files 객체는 다양한 기능들을 제공하며, 성능에 대한 부분도 개선되었다.
 */
public class NewFilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("File exists::" + Files.exists(file));

        try {
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + "File already exist");
        }

        try {
            Files.createDirectories(directory);
        } catch(FileAlreadyExistsException e) {
            System.out.println(directory + "Directory already exists");
        }

//        Files.delete(file);
//        System.out.println("File deleted");

        System.out.println("Is regular file::" + Files.isRegularFile(file));
        System.out.println("Is directory::" + Files.isDirectory(directory));
        System.out.println("File name::" + file.getFileName());
        System.out.println("File size::" + Files.size(file) + "bytes");

        //파일이름 변경
        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");

        System.out.println("Last modified::" + Files.getLastModifiedTime(newFile));

        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("======Attributes=====");
        System.out.println("Created time::" + attrs.creationTime());
        System.out.println("Is directory::" + attrs.isDirectory());
        System.out.println("Is regular file::" + attrs.isRegularFile());
        System.out.println("is symbolic link::" + attrs.isSymbolicLink());
        System.out.println("size::" + attrs.size());
    }

}
