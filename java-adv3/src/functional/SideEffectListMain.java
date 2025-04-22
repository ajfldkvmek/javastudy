package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Ccc");

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        // 이렇게 컬랙션 데이터에 변화가 있을 때 이렇게 하지말고 새로 데이터 생성해라
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Ccc");

        // 아래 와 같이 데이터의 원본을 유지하는 것을 권장
        System.out.println("before list2 = " + list2);
        List<String> list2Complete = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("list2Complete = " + list2Complete);

    }

    private static List<String> changeList2(List<String> list2) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            newList.add(i, list2.get(i) + "_complete");
        }
        return newList;
    }

    private static void changeList1(List<String> list1) {
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, list1.get(i) + "_complete");
        }
    }
}
