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

        List<Student> dir = direct(students);
        List<Student> lambda = lambda(students);

        System.out.println("dir = " + dir);
        System.out.println("lambda = " + lambda);

    }

    private static List<Student> lambda(List<Student> students) {
        return GenericMapper.map(GenericFilter.filter(students, student -> student.getScore() >= 80), f -> f);
    }

    private static List<Student> direct(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                result.add(student);
            }
        }
        return result;
    }


}
