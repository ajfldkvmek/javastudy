package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

    public static void main(String[] args) {

        MyHashSetV2 set = new MyHashSetV2(10);
        MemberOnlyHash m1 = new MemberOnlyHash("A");
        MemberOnlyHash m2 = new MemberOnlyHash("A");

        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
        System.out.println("m1.equals(m2) ? " + m1.equals(m2));

        //객체 생성시 equals & hashCode 를 하지 않으면 다른 해시값이 생성되어 중복데이터가 삽입될 수 있음
        //hashCode 만 사용할 경우 contains 로 값을 찾지 못하는 경우가 발생함
        //이 때문에 equals 와 hashCode 를 모두 사용해야 중복값도 입력되지 않고 갑도 찾을 수 잇음
        set.add(m1);
        set.add(m2);
        
        System.out.println(set);
    }
}
