package lambda.lambda4.mystream;

import lambda.lambda4.filter.GenericFilter;
import lambda.lambda4.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number2 {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("A", 100)
                , new Student("B", 80)
                , new Student("C", 30)
                , new Student("D", 40)
                , new Student("E", 50)
        );

        List<String> dir = direct(students);
        List<String> lambda = lambda(students);

        System.out.println("dir = " + dir);
        System.out.println("lambda = " + lambda);

    }

    private static List<String> lambda(List<Student> students) {
        return GenericMapper.map(
                GenericFilter.filter(students, student -> student.getScore() >= 80)
                , Student::getName);
//        return GenericMapper.map(
//                GenericFilter.filter(students, student -> student.getScore() >= 80)
//                , f -> f.getName());
    }

    private static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                result.add(student.getName());
            }
        }
        return result;
    }


}
