package reflection;

import java.lang.reflect.Constructor;

public class ConstructV1 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz = Class.forName("reflection.data.BasicData");

        System.out.println("========= construct() ===========");
        Constructor<?>[] constructors = clazz.getConstructors();

        // public 만 출력
        // 생성자의 경우 상속의 개념이 없기 때문에 자신이 선언한 public 생성자만 출력됨
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // 접근제어자 관계없이 자신이 선언한 모든 것
        System.out.println("========== declaredConstruct ============");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
}
