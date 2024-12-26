package network.exception;

/**
 *  자바 네트워크 시스템에서 발생하는 예외들
 *
 *  1.Connect
 *      - UnknownHostException
 *          IP주소가 없거나 DNS가 잘못되었을 경우
 *      - ConnectException
 *          IP주소는 있지만 포트가 없을 경우
 *          서버에서 차단(ex. 방화벽 등) 으로 막을 경우
 *          => TCP 통신 전 handshake 과정에서 서버에서 RST 패킷을 받을 경우 발생함
 *
 *
 *
 *
 *  **************매우중요****************
 *  Timeout 은 OS 마다 조금씩 다른데
 *     윈도우의 경우  :   21초
 *     리눅스의 경우  :   75 ~ 120 초 사이
 *     맥OS 경우     :   75초
 *
 *   하지만 일반적으로 이렇게 Timeout 을 계속 기다리는 것은 바람직하지 못하기 때문에 일반적으로 시간을 지정한다
 *  2.Timeout
 *
 *      - Connect Timeout -> 연결 자체의 문제
 *
 *      - TCP Socket(Read) Timeout -> 연결은 됐지만 그 이후 정보를 받지 못할 때 ( ex. 서버 과부하 등 )
 *          기본적으로 이런 상황일 때 클라이언트는 무한정 대기상태가 된다 -> DDOS 생각하면됨
 *          이 에러는 클라이언트 소캣 생성시 timeout 을 설정하면 된다 <<< 매우 자주 발생하는 원인중 하나이기 때문에 매우 중요하다!
 *
 *
 *
 *
 *  3. closed
 *      상대방이 연결 종료후 데이터를 읽으면 EOF가 발생함
 *
 *      - -1, null, EOFException : 연결 끊어야함
 *
 *      - RST 패킷 받은 후 read 호출 -> Broken pipe
 *
 *      - 자신의 소캣 닫은 후 read/write -> socket is closed
 *
 */