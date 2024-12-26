package collection.link;

public class MyLinkedListV2Main {

    public static void main(String[] args) {

        MyLinkedListV2 list = new MyLinkedListV2();

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
        
        list.remove(2);
        System.out.println(list);

        list.add(2, "Q");
        System.out.println(list);
    }
}
