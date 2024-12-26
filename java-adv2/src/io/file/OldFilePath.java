package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");

        System.out.println("path::" + file.getPath());
        //절대경로
        System.out.println("Absolute path::" + file.getAbsolutePath());

        //정규경로 - .. 같은 디렉토리 이동을 포함한 모든 경로이동을 마친 경로 - 하나의 경로만 존재함
        System.out.println("Canonical Path::" + file.getCanonicalPath());

        File[] files = file.listFiles(); //디렉토리에 있는 모든 파일목록 가져오는 것
        for (File f : files) {
            System.out.println( (f.isFile() ? "F" : "D") + "|" + f.getName());
        }


    }
}
