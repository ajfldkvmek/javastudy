package collection.array;

public class MyArrayListV2Main {

    public static void main(String[] args) {

        MyArrayListV2 list = new MyArrayListV2();

        System.out.println("===데이터 추가===");
        System.out.println(list);

        list.add("A");
        System.out.println(list);
        list.add("B");
        System.out.println(list);
        list.add("C");
        System.out.println(list);

        list.set(2, "F");
        System.out.println(list);

        list.add("X");
        System.out.println(list);
        list.add("Y");
        System.out.println(list);
        

        list.add("Z");
        System.out.println(list);
    }
}
