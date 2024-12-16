package collection.link;

public class MyLinkedListV3Main {

    public static void main(String[] args) {

        MyLinkedListV3<String> stringList = new MyLinkedListV3();

        System.out.println("===데이터 추가===");
        System.out.println(stringList);

        stringList.add("A");
        System.out.println(stringList);
        stringList.add("B");
        System.out.println(stringList);
        stringList.add("C");
        System.out.println(stringList);

        stringList.set(2, "F");
        System.out.println(stringList);

        stringList.add("X");
        System.out.println(stringList);
        stringList.add("Y");
        System.out.println(stringList);

        stringList.remove(2);
        System.out.println(stringList);

        stringList.add(2, "Q");
        System.out.println(stringList);

        MyLinkedListV3<Integer> intList = new MyLinkedListV3();
        intList.add(1);
        System.out.println(intList);
        intList.add(2);
        System.out.println(intList);
        intList.add(3);
        System.out.println(intList);

    }
}
