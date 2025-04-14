package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Kim", 1, 88),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        //1. 학년별로 학생들을 그룹화
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade  // 그룹화 기준
//                        Collectors.toList()  // 다운스트림: 학생을 리스트로 수집인데 이건 생략 가능
                ));
        System.out.println("collect1 = " + collect1);

        //2. 학년별로 학생들의 이름 출력
        Map<Integer, List<String>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade, // 그룹화 기준
                        Collectors.mapping(
                                Student::getName, //학생 -> 학생이름
                                Collectors.toList()) // list로 수집
                ));
        System.out.println("collect2 = " + collect2);


        //3. 학년별로 학생들의 수 출력
        Map<Integer, Long> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
        System.out.println("collect3 = " + collect3);



        //4. 학년별로 학생들의 평균
        Map<Integer, Double> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingDouble(Student::getScore)
                ));
        System.out.println("collect4 = " + collect4);



    }

}
