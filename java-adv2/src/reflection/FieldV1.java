package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {

    public static void main(String[] args) {
        Class<BasicData> Clazz = BasicData.class;

        //해당 클래스와 상위클래스에 선언된 모든 public 필드를 반환
        System.out.println("====== fields() =====");
        Field[] fields = Clazz.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        //해당 클래스에서 선언된(접근제어자와 관계 없이) 모든 필드를 반환
        System.out.println("====== declaredFields =====");
        Field[] declaredFields = Clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
