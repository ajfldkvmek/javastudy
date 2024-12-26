package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *  과거 자바에서 파일을 다루던 방식
 *
 *  File 객체를 생성하였다고 바로 파일이나 디렉토리가 만들어지는 것이 아님
 *  메소드를 통해 생성해주어야 실제로 생성이 된다!
 *
 *  최근에는 File 객체보다는 Files 와 Path 가 등장 (JAVA7 부터)
 */
public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("File exists::" + file.exists());

        boolean created = file.createNewFile();
        System.out.println("File created::" + created);

        boolean dirCreated = directory.mkdir();
        System.out.println("Directory Created::" + dirCreated);

//        boolean deleted = file.delete();
//        System.out.println("File Deleted::" + file.isFile());

        System.out.println("Is File::" + file.isFile());
        System.out.println("Is directory::" + directory.isDirectory());
        System.out.println("File Name::" + file.getName());
        System.out.println("File size::" + file.length() + "bytes");

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed::" + renamed);


        long lastModified = newFile.lastModified();
        System.out.println("Last modified::" + new Date(lastModified));

    }

}
