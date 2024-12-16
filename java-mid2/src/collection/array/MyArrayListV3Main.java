package collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {

        MyArrayListV3 list = new MyArrayListV3();

        System.out.println("===데이터 추가===");
        System.out.println(list);

        list.add("A");
        System.out.println(list);
        list.add("B");
        System.out.println(list);
        list.add("C");
        System.out.println(list);

        //원하는 위치 추가
        System.out.println("addLast");
        list.add(3, "addLast"); //O(1)
        System.out.println(list);

        System.out.println("addFirst");
        list.add(0, "addFirst"); // O(n)
        System.out.println(list);

        list.remove(list.size()-1);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

    }
}
