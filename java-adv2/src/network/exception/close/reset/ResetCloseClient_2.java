package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient_2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결::" + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //client < server :: FIN
        Thread.sleep(1000);

        //client > server : PUSH >>> 아몰랑 니가 안받아도 난 보낼래~
        //이는 TCP 규약을 어기는 것이기 때문에 RST 메세지를 받게된다
        output.write(1);

        //client < server :: RST
        Thread.sleep(1000); //RST 메세지 전송 대기

        // java.net.SocketException: Connection reset
        try {
            int read = input.read();
            System.out.println("read::" + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // java.net.SocketException: Broken pipe
        try {
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     *  참고
     *  Socket is closed 오류는 자기 자신의 소캣을 종료한 뒤 read/write 를 하려고 할 경우 발생함
     */
}
