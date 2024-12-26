package collection.set.member;

public class JavaHashCodeMain {

    public static void main(String[] args) {

        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        System.out.println("member1 == member2 ? " + (member1 == member2));
        System.out.println("member1 equals member2 ? " + (member1.equals(member2)));

        //hashCode 메소드를 오버라이드 하지 않으면 이 값이 다르게 나온다.
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
    }
}
