package thread.cas;

/**
 *  CAS 연산은 lock 을 사용하지 않고 스레드처리를함(심화 내용임)
 *
 *  CAS 는 Synchronized 나 ReentrantLock 을 사용하지 않고 스레드 처리를 함
 *
 *  Lock 을 사용하는 방식은 직관적이지만 상대적으로 무거움
 *  또한 wait/wake 상태를 사용하기 때문에 그 과정에서 발생하는 연산으로 인한 속도의 저하도 있음
 *
 *  cas 는 이러한 연산을 하지 않고 처리를 하는데
 *  Compare and set 또는 compare and swap 연산 이라고 함 - Lock Free 기법임
 *  이는 락을 완전히 대체하지는 못하기 때문에 간단한 연산에 한해서 사용할 수 있음
 *  만약 처리하는 데이터의 양이 크고 복잡하다면 lock 을 사용해야함
 *
 */