package chat.server;

import chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//커멘드 패턴
/**
 *  커맨드 패턴이란
 *  요청을 독립적인 객체로 변환해서 처리하는 것
 *
 *  커맨트 패턴의 특징
 *  분리      :     작업을 호출하는 객체와 작업을 수행하는 객체를 분리한다.
 *  확장성    :     기존 코드를 변경하지 않고 새로운 명령을 추가할 수 있다.
 *
 *  복잡성이 증가한다는 단점이 있다.
 *  단순히 if 분기처리 몇개로 처리할 수 있는 경우에는 사용하지 않는 것이 좋음
 */
public class CommandManagerV3 implements CommandManager{

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandManagerV3(SessionManager sessionManager) {
        commandMap.put("/join", new JoinCommand(sessionManager));
        commandMap.put("/message", new MessageCommand(sessionManager));
        commandMap.put("/change", new ChangeCommand(sessionManager));
        commandMap.put("/users", new UsersCommand(sessionManager));
        commandMap.put("/exit", new ExitCommand());
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

        Command command = commandMap.get(key);
        if (command == null) {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
            return;
        }
        command.execute(args, session);
    }
}
