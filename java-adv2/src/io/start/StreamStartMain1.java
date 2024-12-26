package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {

        /**
         *  추가로 FileOutputStream 에는 append 옵션이 있는데
         *  new FileOutputStream(파일명, true) 로 선언할 경우
         *  파일이 존재하면 이어쓰기 기능이 된다( 기본값은 false 로, 이는 파일 덮어쓰기의 역할)
         */
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);

        fos.close(); //자바에서 외부자원을 쓸 때는 항상 사용후 닫아줘야함 (-> 내부 객체의 경우 닫지 않았도 GC가 처리해주긴함 - 그래도 하는게 좋음)

        FileInputStream fis = new FileInputStream("temp/hello.dat");
/*        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read()); //다 읽었으면 -1 이 출력됨*/
        //처럼 한 줄 씩 하는 게 아니라 반복문으로 출력한다.(일반적으로)
        /**
         *  fis.read() 의 반환값이 int 인 이유는
         *  자바에서 byte 는 -128~127의 값으로 출력됨
         *  하지만 int의 경우 부호없이 0~255의 값으로 출력가능함
         *  왜 파일의 끝이 -1 로 출력되는지 생각해보자
         *  만약 byte 값으로 출력된다고 했을 때 '-1' 이라는 놈이 파일의 끝이 아니라 실제 '-1' 이라는 문자열이라면?
         *  이 경우 -1을 만나게 될 경우 파일의 끝이 아니라도 종료될 수 있음
         */
        int data;
        while ((data = fis.read()) != -1) {
            System.out.println(data);
        }

        fis.close();
    }
}
