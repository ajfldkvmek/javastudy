package lambda.methodref.start;

public class Person {

    private String name;

    public Person() {
        this("unknown");
    }

    public Person(String name) {
        this.name = name;
    }

    public static String greeting(){
        return "Hello";
    }

    //정적메소드 매개변수 추가
    public static String greetingWithName(String name){
        return "Hello " + name;
    }

    public String introduce() {
        return "I'm " + name;
    }

    //인스턴스 메소드
    public String introduceWithNumber(int number) {
        return "I'm " + name + ", my number is " + number;
    }

}
