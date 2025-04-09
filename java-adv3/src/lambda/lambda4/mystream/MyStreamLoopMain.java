package lambda.lambda4.mystream;

import java.util.List;

public class MyStreamLoopMain {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("apple", 100),
                new Student("banana", 80),
                new Student("c", 70),
                new Student("d", 60),
                new Student("e", 87)
        );

//        List<String> result1 = ex1(students);
//        System.out.println("result1 = " + result1);
//
//        //점수 80이상, 이름길이 5글자, 대문자로
//        List<String> result2 = ex2(students);
//        System.out.println("result2 = " + result2);
//
        ex3(students);
    }

    private static void ex3(List<Student> students) {

        //스트림한 결과를 직접 반복하면 외부반복 -> 추가적으로ㅑ 제어가 필요하면 이거
        //아래와 같이 스트림을 실행하면서 처리하면 내부반복 -> 단순 반복처리만 필요하면 이거
        MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
                .filter(s -> s.getName().length() >= 5)
                .map(s -> s.getName().toUpperCase())
                .forEach(System.out::println);
//        MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
//                .filter(s -> s.getName().length() >= 5)
//                .map(s -> s.getName().toUpperCase())
//                .forEach( name -> System.out.println(name) );
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
