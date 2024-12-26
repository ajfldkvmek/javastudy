package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");


        /**
         *  ServerSocket 는 accept 메소드를 통해 단순히 연결만 하는 역할을 한다.
         *  통신은 Socket 객체끼리 하는 것
         *
         *  ServerSocket 의 accept 객체는 socket 객체가 접근할 대 까지 waiting 을 함
         * ( 실질적은 연결은 OS 단에서 처리(3-way-handshaking)되고 JAVA 는 그 정보를 가져오기만 )
         */
        ServerSocket serverSocket = new ServerSocket(PORT);

        log("서버 소캣 시작 - 리스닝 포트::" + PORT);

        Socket socket = serverSocket.accept(); //누군가 port 로 접속하면 socket 생성해서 데이터 입력
        log("소캣 연결: " + socket);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        //받기
        String received = input.readUTF();
        log("client -> server: " + received);

        //보내기
        String toSend = received + "World!";
        output.writeUTF(toSend);
        log("client <- server: " + toSend);

        //자원정리 - 닫는 순서는 역순으로
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }


}
