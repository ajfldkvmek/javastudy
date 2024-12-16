package generic.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
         Integer i = 10;
         Object obj = GenericMethod.objectMethod(i);
         //아래와 같이 반환타입이 Object 일 때 Integer로 받고싶으면 캐스팅을 해줘야함
         //Integer integer = (Integer) GenericMethod.objectMethod(i);

         // 타입인자 명시적 전달(Type Argument) 명시적 전달을 하면 위와 같은 불편함을 피할 수 있음(제네릭 메소드 사용시)
         Integer integer2 = GenericMethod.<Integer>genericMethod(i);


        //이렇게 메소드에서 타입추론을 사용할 경우 아래와 같이 타입지정이 생략이 가능하다.(생략된 것이지 타입정보 전달하는 중)
         Integer integerValue = GenericMethod.genericNumberMethod(10);
         Double doubleValue = GenericMethod.genericNumberMethod(10.5);

    }

}
