package network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class SessionV5 implements Runnable {

    private final Socket socket;
    public SessionV5(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {

        try ( socket;
               DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                ){
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
        } catch (IOException e) {
            log(e);
        }
        //socket 종료됐는지 확인용
        log("연결종료::" + socket.isClosed());
    }
}
