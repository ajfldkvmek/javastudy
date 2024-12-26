package network.tcp.v6;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

public class SessionV6 implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManagerV6 sessionManager;
    private boolean closed = false;

    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.sessionManager = sessionManager;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.sessionManager.add(this);
    }

    @Override
    public void run() {

        try {
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
        } finally {
            close();
        }
    }

    //main 스레드에서 끝낼수도, 외부 스레드에서 끝낼수도 있기 때문에 외부에 메소드를 만들어준다!
    //session 종료 or server 종료
    //if 동시에 종료해서 여러곳에서 호출한다면?
    //동시에 호출은 synchronized 를 통해 제어
    //여러곳에서 호출은 flag 를 통해 이미 호출되었다면 더이상 호출이 안되도록
    //이렇게 외부에서 접근해서 종료할 수 있으려면 try with resources 를 사용할 수 없다
    public synchronized void close() {
        if(closed) return;
        closeAll(socket, input, output);
        closed = true;
        log("연결종료::" + socket);
    }
}
