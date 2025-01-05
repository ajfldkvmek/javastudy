package annotation.java;

public class DeprecatedMain {

    public static void main(String[] args) {

        System.out.println("DeprecatedMain.main");

        DeprecatedClass dc = new DeprecatedClass();
        dc.call1();
        dc.call2(); //
        dc.call3(); //이렇게 Deprecated 어노테이션으로 설정해준 코드에 대해 경고 표기가 가능하다. 빨간줄이지만 컴파일은 가능하다(컴파일 에러는 아님)
    }

}

