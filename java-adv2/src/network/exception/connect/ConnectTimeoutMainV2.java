package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectTimeoutMainV2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            //소켓 생성시 파라메터가 없으면 연결시도 x
            //InetSocketAddress 를 통해 두 번째 파라메터로 timeout(ms) 을 설정할 수 있다( 이 외에도 여러 설정은 가능 )
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.250", 56789), 1000);
        } catch (ConnectException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));

    }
}
