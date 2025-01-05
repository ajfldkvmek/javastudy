package annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    /**
     *
     * 애노테이션의 상속은 클래스의 상속에서는 되지만
     *
     * 인터페이스의 구현에 의해서는 적용되지 않는다.
     *
     */
    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class);

        print(TestInterface.class);
        print(TestInterfaceImpl.class);
    }

    private static void print(Class<?> clazz) {
        System.out.println("class: " + clazz);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
