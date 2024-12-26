package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) throws IOException {
        unKnownHostEx1(); //잘못된 ip
        unKnownHostEx2(); //잘못된 DNS
        connectionRefused(); // (주로) ip 주소나 도메인은 있지만 포트번호가 없을 때 주로 발생, 방화벽등으로 차단 -> TCP 연결시도중 RST 패캣 받으면 예외발생
    }

    private static void connectionRefused() throws IOException {
        try {
            Socket socket = new Socket("localhost", 45778);
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }

    private static void unKnownHostEx2() throws IOException {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void unKnownHostEx1() throws IOException {
       try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }



}
