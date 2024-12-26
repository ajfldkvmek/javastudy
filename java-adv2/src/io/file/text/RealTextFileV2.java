package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RealTextFileV2 {
    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("=== Write String ===");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        //파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        //파일에서 읽기 - 한줄씩
        List<String> lines = Files.readAllLines(path, UTF_8);
        System.out.println("=== Read String ===");

//        System.out.println(readString);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        System.out.println("===========================================");
        //한줄씩 읽기 스트림을 사용한 방식
        //이 방식은 파일 전체를 읽어와서 한 줄 씩 출력하는 것이 아니라 처음부터 한줄씩 불러옴 -> 메모리 사용량이 줄어듦
        Stream<String> lineStream = Files.lines(path, UTF_8);
        lineStream.forEach(line -> System.out.println(line));
        lineStream.close();
    }
}
