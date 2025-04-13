package lambda.methodref.start;

import java.util.function.Function;

public class MethodRefEx3 {

    public static void main(String[] args) {

        Person person1 = new Person("Kim");
        Person person2 = new Person("Lee");
        Person person3 = new Person("Park");

        //람다
        Function<Person, String> f1 = (Person person) -> person.introduce();
        System.out.println("person1.introduce() = " + f1.apply(person1));
        System.out.println("person2.introduce() = " + f1.apply(person2));
        System.out.println("person3.introduce() = " + f1.apply(person3));
        System.out.println("----------------------------------------------------");

        // 메소드 참조, 타입이 첫 번쨰 매개변수가됨, 그 후 첫번쨰 매개변수의 메서드 호출, 나머지는 순서대로 매개변수 전달
        // 즉 Person 을 람다의 첫번쨰 매개변수로 사용하고
        // 인스턴스 메소드인 introduce 를 호출한다.
        Function<Person, String> f2 = Person::introduce; //타입::인스턴스 메소드
        System.out.println("person1.introduce() = " + f2.apply(person1));
        System.out.println("person2.introduce() = " + f2.apply(person2));
        System.out.println("person3.introduce() = " + f2.apply(person3));

        //이렇게 특정한 타입의 임의 객체에 대해 동일한 인스턴스 메소드를 호출하는 패턴을 메서드 참조로 쉽게 표현할 수 있다.

    }
}

