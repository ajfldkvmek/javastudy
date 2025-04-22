package functional;

public class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Getter 만 제공되었기에 변경이 필요한 경우 기존 객체를 변경을 하는 것이 아니라 새로운 객체를 반환한다.
    public ImmutablePerson withAge(int age) {
        return new ImmutablePerson(name, age);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
