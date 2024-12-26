package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-obj.dat";

    /**
     *
     *  참고로 ArrayList 도 직렬화가 되어있음
     *
     */
    @Override
    public void add(Member member) throws IOException {
        List<Member> members = findAll();
        members.add(member);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            //객체 직렬화는 객체를 통으로 파일로 저장함
            //member 하나를 넣게되면 member 하나당 파일 하나로 됨
            //member 데이터 전체를 저장하려면 자바컬렉션을 넘겨줘서 저장해야함
            oos.writeObject(members);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object findObject = ois.readObject();
            return (List<Member>) findObject;
        } catch(FileNotFoundException e) {
            return new ArrayList<>();
            //여기서는 List.of() 를 사용할 수 없음
            //List.of() 는 immutable 이기 때문
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
