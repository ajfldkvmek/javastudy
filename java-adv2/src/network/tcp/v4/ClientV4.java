package network.tcp.v4;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

public class ClientV4 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        //finally 블록에서 접근하기 위해 try 외부에서 선언
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("소캣 연결::" + socket);

            Scanner sc = new Scanner(System.in);
            while (true) {
                //서버에게 문자 보ㅓ내기
                System.out.print("send: ");
                String toSend = sc.nextLine();
                output.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equalsIgnoreCase("exit")) {
                    break;
                }
                //서버에서 문자 보내기
                String receive = input.readUTF();
                System.out.println("client <- server: " + receive);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, input, output);
            log("연결종료::" + socket);
        }
   }
}
