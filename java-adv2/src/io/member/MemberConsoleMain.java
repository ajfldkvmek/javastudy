package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.ObjectMemberRepository;
//import io.member.impl.MemoryMemberRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

//    private static final MemberRepository repository = new MemoryMemberRepository();
//    private static final MemberRepository repository = new FileMemberRepository();
//    private static final MemberRepository repository = new DataMemberRepository();
    private static final MemberRepository repository = new ObjectMemberRepository();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.회원등록 | 2.회원 목록 조회 | 3.종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine(); //newline 제거

            switch (choice) {

                case 1:
                    //등록
                    registerMember(sc);
                    break;

                case 2:
                    //조회
                    displayMembers();
                    break;

                case 3:
                    //종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못눌렀엉!");
                    break;

            }
        }
    }


    private static void registerMember(Scanner sc) throws IOException {
        System.out.print("ID 입력: ");
        String id = sc.nextLine();
        System.out.print("Name 입력: ");
        String name = sc.nextLine();
        System.out.print("Age 입력: ");
        int age = sc.nextInt();
        Member newMember = new Member(id, name, age);
        //win:: ctrl+alt+b -> 구현체로 이동
        repository.add(newMember);
    }


    //ctrl + shift + 방향키 <<< 메소드 이동
    private static void displayMembers() {
        List<Member> members = repository.findAll();
        System.out.println("=== 회원 목록 ===");
        for (Member member : members) {
            System.out.printf("[ID: %s, Name: %s, Age: %d]\n", member.getId(), member.getName(), member.getAge());
        }
    }
}
