package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command{

    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {

        List<String> allUsername = sessionManager.getAllUsername();
        //StringBuffer 의 경우 멀티 스레드 상황에서 사용하기 때문에
        //단일스레드로 작업하는 이 코드의 경우 StringBuilder 를 사용하도록 하자
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자 : ").append(allUsername.size()).append("\n");
        for (String s : allUsername) {
            sb.append(" - ").append(s).append("\n");
        }
        //요청한 사용자에게만 보내기
        session.send(sb.toString());

    }
}
