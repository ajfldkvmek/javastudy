package network.tcp.v2;

/**
 *  서버는 여러 클라이언트에서의 접속을 혀용할 수 있어야 한다.
 *  하지만 S2, C2 의 경우 하나의 클라이언트-서버 통신만을 생성할 수 있다.
 *  -> 새로운 클라이언트가 접속하면 accept 객체를 호출 할 수 가 없음
 *  그렇다면 여러 클라이언트를 접속가능하게 하기위해서는 어떻게 해야할까?
 *  -> 별도의 블로킹 작업을 별도의 스레드에서 처리해야한다!
 *
 *  즉 연결을 하기위한 스레드와
 *  메세지를 받는 스레드
 *  두 스레드를 필요로 한다
 */