package was.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class HttpServer {

    private final int PORT;
    private final ExecutorService es = Executors.newFixedThreadPool(10);
    private final ServletManager servletManager;

    public HttpServer(int port, ServletManager servletManager) {
        this.PORT = port;
        this.servletManager = servletManager;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버시작 PORT: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandler(socket, servletManager));

        }
    }
}
