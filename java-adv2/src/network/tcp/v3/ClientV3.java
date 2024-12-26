package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV3 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
//        socket.getInputStream();
//        socket.getOutputStream();
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소캣 연결::" + socket);

        Scanner sc = new Scanner(System.in);
        while(true){
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
        //자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
