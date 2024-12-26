package generic.ex4;

public class GenericMethod {

    /**
     * 
     *  제네릭 타입은 클래스 선언시(객체 생성 시점에 타입지정)
     *  
     *  제네릭 타입은 메소드 정의시(메소드 호출 시점에 타입지정)
     *
     * 
     * 제네릭 타입은 static 메서드에 타입 매개변수로 사용할 수 없음
     * static 메소드는 인스턴스 단위가 아니라 클래스단위로 작동하기 때문에 제네릭"타입"과는 무관하다.
     *
     * 따라서 static 메서드에 제네릭을 도입하려면 제네릭 메소드를 사용해야한다.
     *
     *
     */
    public static Object objectMethod(Object obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

    
    //제네릭 메소드
    public static <T> T genericMethod(T obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

    //처럼 제네릭 메소드도 타입 제한 가능
    public static <T extends Number> T genericNumberMethod(T obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

}
