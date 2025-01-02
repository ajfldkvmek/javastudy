package was.v4;


import was.v3.HttpRequestHandlerV3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class HttpServerV4 {

    private final int PORT;
    private final ExecutorService es = Executors.newFixedThreadPool(10);

    public HttpServerV4(int port) {
        this.PORT = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버시작 PORT: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandlerV4(socket));

        }
    }
}
