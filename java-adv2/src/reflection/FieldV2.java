package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User("id1", "name1", 1);
        System.out.println("name::" + user.getName());

        Class<? extends User> Clazz = user.getClass();
        Field nameField = Clazz.getDeclaredField("name");


        //private 필드에 접근 허용필요
        nameField.setAccessible(true); // 접근 권한을 바꾸지 않으면 접근에러가 발생한다. 리플렉션을 사용하면 이렇게 접근권한을 변경하여 값을 수정할 수 있다.(메소드에도 적용 가능)
        nameField.set(user, "name2");
        System.out.println("변경된 이름::" + user.getName());
    }
}
