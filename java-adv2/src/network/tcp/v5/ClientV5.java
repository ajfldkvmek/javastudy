package network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class ClientV5 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        try(
                Socket socket = new Socket("localhost", PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ){
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
        }
   }
}
