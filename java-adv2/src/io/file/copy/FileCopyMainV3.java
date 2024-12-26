package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


/**
 *  이전의 예제들은 파일을 복사할 때
 *  파일(copy.dat) -> 자바(byte) -> 파일(copy_new.dat) 의 과정을 거쳤다
 *
 *  하지만 Files.copy() 의 경우 자바에 파일 데이터를 불러오지 않고 운영체제의 파일 복사기능을 사용한다
 *  따라서 지금까지의 과정 중 가장 빠르다.
 *  따라서 단순 파일복사만의 목적이라면 이 방법을 사용한느 것이 가장 좋다.
 *
 *  하지만 파일의 정보를 불러와 처리하거나 스트림을 통해 네트워크 등으로 전송을 하기 위해선 직접 스트림으로 처리하는 것이 바람직하다
 */
public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long startMs = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endMs = System.currentTimeMillis();
        System.out.println("time::" + (endMs - startMs) + "ms");

    }
}
