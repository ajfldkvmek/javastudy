package lambda.methodref.start;

import java.util.function.Function;

public class MethodRefEx2 {

    public static void main(String[] args) {

        //정적 메소드 참조
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        //람다로 바꿀 때 매개변수가 전달될 경우 아래와 같이 메소드명만 적어주고 매개변수는 생략가능하다
        //매개변수가 여러개일 경우 순서대로 전달됨
        Function<String, String> staticMethod2 = Person::greetingWithName;

        System.out.println(staticMethod1.apply("Hello"));
        System.out.println(staticMethod2.apply("Hello"));

        // 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Function<Integer, String> instanceMethod1 = n -> person.introduceWithNumber(n);
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;

        System.out.println("instanceMethod1.get() = " + instanceMethod1.apply(2));
        System.out.println("instanceMethod2.get() = " + instanceMethod1.apply(2));

        // 생성자 참조
        Function<String, Person> newPerson1 = name -> new Person(name);
        Function<String, Person> newPerson2 = Person::new;
        //위 두 문장은 동일한 역할
        //메소드 참조시 뒤에 '()'가 없는 이유는 단순히 참조만 한다는 말이다
        //'()' 는 실제로 메소드를 생성한다는 의미!

        System.out.println("newPerson1.apply() = " + newPerson1.apply("Kim"));
        System.out.println("newPerson2.apply() = " + newPerson2.apply("Kim"));

    }
}
