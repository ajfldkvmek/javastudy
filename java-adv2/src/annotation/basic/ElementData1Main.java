package annotation.basic;

import java.util.Arrays;

public class ElementData1Main {

    public static void main(String[] args) {
        Class<ElementData1> clazz = ElementData1.class;
        AnnoElement annoElement = clazz.getAnnotation(AnnoElement.class);

        System.out.println("annoElement.value() = " + annoElement.value());
        System.out.println("annoElement.count() = " + annoElement.count());
        System.out.println("annoElement.tags() = " + Arrays.toString(annoElement.tags()));

    }
}
