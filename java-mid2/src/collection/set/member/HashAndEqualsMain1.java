package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

    public static void main(String[] args) {

        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");

        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
        System.out.println("m1.equals(m2) ? " + m1.equals(m2));

        //객체 생성시 equals & hashCode 를 하지 않으면 다른 해시값이 생성되어 중복데이터가 삽입될 수 있음
        set.add(m1);
        set.add(m2);
        
        System.out.println(set);
    }
}
