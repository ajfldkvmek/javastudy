package annotation.java;

/**
 *  간혹 deprecated 라는 문구를 볼 수 있는데
 *  이는 사용하지 않는 것을 권장하는 것
 *  ex) 취약점이 발생할 수 있는 메소드 등
 */
public class DeprecatedClass {


    public void call1() {
        System.out.println("DeprecatedClass.call1");
    }

    //향후에 문제가 발생할 수 있음을 체크하기 위함
    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call2");
    }

    //이렇게 어느 시점부터 사용하지 말것과
    //삭제할 것이라는 것을 명시할 수 있음
    @Deprecated(since = "2,4", forRemoval = true)
    public void call3() {
        System.out.println("DeprecatedClass.call3");
    }
}
