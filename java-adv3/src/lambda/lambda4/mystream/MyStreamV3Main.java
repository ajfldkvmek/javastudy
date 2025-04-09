package lambda.lambda4.mystream;

import java.util.List;

public class MyStreamV3Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("apple", 100),
                new Student("banana", 80),
                new Student("c", 70),
                new Student("d", 60),
                new Student("e", 87)
        );

        List<String> result1 = ex1(students);
        System.out.println("result1 = " + result1);

        //점수 80이상, 이름길이 5글자, 대문자로
        List<String> result2 = ex2(students);
        System.out.println("result2 = " + result2);
    }

    private static List<String> ex2(List<Student> students) {
        return MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .filter(s -> s.getName().length() >= 5)
                .map(s -> s.getName().toUpperCase())
                .toList();
    }

    private static List<String> ex1(List<Student> students) {
        return MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
                .map(s -> s.getName()).toList();
    }

}
