package annotation.validator;

public class User {

    @Range(min = 1, max = 100, message = "나이는 1과 100 사이")
    private int age;

    @NotEmpty(message = "이름이 비었어!")
    private String name;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
