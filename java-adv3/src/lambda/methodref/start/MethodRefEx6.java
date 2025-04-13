package lambda.methodref.start;

import java.util.function.BiFunction;

public class MethodRefEx6 {

    public static void main(String[] args) {

        //임의 객체의 인스턴스 메소드 참조
        Person person = new Person("Kim");

        //람다
        BiFunction<Person, Integer, String> fun1 =
                (Person p, Integer number) -> p.introduceWithNumber(number);

        System.out.println("fun1.apply(person, 2) = " + fun1.apply(person, 2));

        //메소드 참조
        //타입이 첫 번째 매개변수, 그리고 첫번 째 매개변수의 메소드 호출, 나머지는 순서대로 메소드에 매개변수 전달
        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
        System.out.println("fun2.apply(person, 12) = " + fun2.apply(person, 12));

    }

}
