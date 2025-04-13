package lambda.methodref.start;

import java.util.function.Supplier;

public class MethodRefEx1 {

    public static void main(String[] args) {

        //정적 메소드 참조
//        Supplier<String> staticMethod = () -> Person.greeting();
//        System.out.println("staticMethod.get() = " + staticMethod.get()); ->

        //클래스 정적 메소드
        Supplier<String> supplier = Person::greeting;
        System.out.println("supplier.get() = " + supplier.get());

        // 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Supplier<String> instanceMethod1 = () -> person.introduce();
        Supplier<String> instanceMethod2 = person::introduce;

        System.out.println("instanceMethod1.get() = " + instanceMethod1.get());
        System.out.println("instanceMethod2.get() = " + instanceMethod1.get());

        // 생성자 참조
        Supplier<Person> newPerson1 = () -> new Person();
        Supplier<Person> newPerson2 = Person::new;
        //위 두 문장은 동일한 역할
        //메소드 참조시 뒤에 '()'가 없는 이유는 단순히 참조만 한다는 말이다
        //'()' 는 실제로 메소드를 생성한다는 의미!

        System.out.println("newPerson1.get() = " + newPerson1.get());
        System.out.println("newPerson2.get() = " + newPerson2.get());

    }
}
