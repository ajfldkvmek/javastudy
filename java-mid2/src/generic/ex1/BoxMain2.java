package generic.ex1;

import java.util.OptionalInt;

public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get();

        System.out.println("integer : " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("stringBox");
        String str = (String) stringBox.get();
        System.out.println("str : " + str);


        //잘못된 인수 전달시
        integerBox.set("asdasasd"); //처럼 object로 넣으면 다 받을 수 있어서 타입이 혼동될 수 있음
        Integer res = (Integer) integerBox.get();
        System.out.println("res : " + res);
    }
}
