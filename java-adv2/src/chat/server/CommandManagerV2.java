package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private final SessionManager sessionManager;
    //정규식에서 사용하는 "|"이 아닌 일반 문자 "|"로 구분하기 위해서
    private static final String DELIMITER = "\\|";

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUserName(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");
        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUserName() + "] " + message);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String changeName = split[1];
            sessionManager.sendAll(session.getUserName() + "님이 " + changeName + "로 이름을 변경하였습니다.");
            session.setUserName(changeName);
        } else if (totalMessage.startsWith("/users")) {
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
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다: "  + totalMessage);
        }


        if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }
//        sessionManager.sendAll(totalMessage);
    }
}
