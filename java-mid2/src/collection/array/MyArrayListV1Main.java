package collection.array;

public class MyArrayListV1Main {

    public static void main(String[] args) {

        MyArrayListV1 list = new MyArrayListV1();

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
        
        //범위 초과
        list.add("Z");
    }
}
