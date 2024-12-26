package thread;


/**
 *  스레드는 다음과 같은 이유로 매우 무겁다.
 *  따라서 스레드를 직접 생성하여 관리하는 것은 지양해야한다.
 *
 *  메모리 할당             : 각 스레드는 자신만의 호출스택을 가지고 있어야함.
 *
 *
 *  운영제제 자원 활용       : 스레드를 생성하는 작업은 운영체제 커널 수준에서 이루어지며 시스템콜을 통해 처리된다
 *                           이는 CPU 와 메모리 리소스를 소모하는 작업이다.
 *
 *  운영체제 스케줄러 설정    : 새로운 스레드가 생성되면 운영체제의 스케줄러는 이 스레드를 관리하고 실행순서를 조정해야 한다
 *                           이는 스케줄링 알고리즘에 따라 추가적인 오베헤드가 발생할 수 있다.
 *
 *  참고로 스레드 하나는 보통 1MB 이상의 메모리를 사용한다.
 *
 *  그래서 스레드를 생성하고 삭제하는 작업을 하는 것이 실제 스레드를 사용한 작업을 하는 것 보다 많은 자원을 사용하는 일도 발생한다.
 *  따라서 스레드가 필요할 때 마다 생성하고 삭제하는 것이 아니라 스레드를 재사용하는 방법을 고려할 수 있다.
 *
 *  그래서! 나온게
 *  자바의 Executor 프레임워크다
 *
 *
 *  Runnable 인터페이스의 불편함
 *  1. 반환값이 없다.
 *  2. 예외처리 (checked exception)을 throw 할 수 없기 때문에 내부에서 처리해주어야함
 */