package collection.array;

public class MyArrayListV4Main {

    public static void main(String[] args) {

        MyArrayListV4<String> stringList = new MyArrayListV4();

        System.out.println("===데이터 추가===");
        System.out.println(stringList);

        stringList.add("A");
        System.out.println(stringList);
        stringList.add("B");
        System.out.println(stringList);
        stringList.add("C");
        System.out.println(stringList);


        MyArrayListV4<Integer> intList = new MyArrayListV4();
        intList.add(1);
        System.out.println(intList);
        intList.add(2);
        System.out.println(intList);
        intList.add(3);
        System.out.println(intList);
    }

}
