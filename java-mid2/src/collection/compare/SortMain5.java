package collection.compare;

import java.util.TreeSet;

public class  SortMain5 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);
        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1);

        /**
         *  TreeSet 은 기본적으로 정렬을 하여 데이털르 삽입한다
         *  따라서
         *  TreeSet<MyUser> treeSet2 = new TreeSet<>();
         *  와 같이 선언할 경우 기본적으로 데이터가 정렬된 형태로 저장되는데,
         *  만약 정렬되는 순서를 지정하고 싶다면
         *
         *  TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
         *  과 같이 선언을 할 때 정렬조건을 파라메터로 설정하면된다.
         */
        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);
        System.out.println("IdComparator 정렬");
        System.out.println(treeSet2);
    }

}