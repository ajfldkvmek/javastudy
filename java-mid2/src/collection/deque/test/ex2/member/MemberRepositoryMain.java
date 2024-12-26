package collection.deque.test.ex2.member;

public class MemberRepositoryMain {

    public static void main(String[] args) {

        Member member1 = new Member("id1", "name1");
        Member member2 = new Member("id2", "name2");
        Member member3 = new Member("id3", "name3");

        MemberRepository repository = new MemberRepository();
        repository.save(member1);
        repository.save(member2);
        repository.save(member3);


        Member findMember1 = repository.findById("id1");
        System.out.println(findMember1);
        Member findMember3 = repository.findById("id3");
        System.out.println(findMember3);

        repository.remove("id2");
        Member removeMember2 = repository.findById("id2");
        System.out.println(removeMember2);
    }
}
