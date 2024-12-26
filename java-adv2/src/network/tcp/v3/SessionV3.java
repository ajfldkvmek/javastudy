package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class SessionV3 implements Runnable {

    private final Socket socket;
    public SessionV3(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            while (true) {
                //받기
                String received = input.readUTF();
                log("client -> server: " + received);

                if (received.equalsIgnoreCase("exit")) {
                    break;
                }
                //보내기
                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client <- server: " + toSend);

            }
            /*
            이렇게 해주면 저 위에서 오류 발생하면 자원정리가 힘들어짐
            -> try-catch-finally 나 try with resource 를 사용해야하는 이유
             */
            log("연결 종료: " + socket);
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        finally {
        //    이렇게 finally 를 통해 자원을 정리해야하지만
        //     input, output 의 경우는 finally 에서는 외부메서드 이므로 정리 불가함
//            log("연결 종료: " + socket);
//            input.close();
//            output.close();
//            socket.close();
//        }
    }
}
