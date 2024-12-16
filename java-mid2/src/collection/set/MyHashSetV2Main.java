package collection.set;

public class MyHashSetV2Main {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        set.add("AB");
        set.add("SET");

        String searchValue = "SET";
        boolean result = set.contains(searchValue);

        System.out.println("set.contains(" + searchValue+ ") ? " + result);


    }
}
