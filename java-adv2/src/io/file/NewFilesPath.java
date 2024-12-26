package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");

        //절대경로
        System.out.println("Absolute path::" + path.toAbsolutePath());

        //정규경로 - .. 같은 디렉토리 이동을 포함한 모든 경로이동을 마친 경로 - 하나의 경로만 존재함
        System.out.println("Canonical Path::" + path.toRealPath());

        Stream<Path> pathStream = Files.list(path);
        List<Path> list =pathStream.toList();
        pathStream.close(); //스트림은 사용이 끝나면 종료해야함

        for (Path p : list) {
            System.out.println( (Files.isRegularFile(p) ? "F" : "D") + " | " + p.getFileName());
        }


    }
}
