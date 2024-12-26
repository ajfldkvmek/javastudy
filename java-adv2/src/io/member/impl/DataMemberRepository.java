package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (dis.available() > 0) {
                //available:: DataInputStream 에서 제공하는 메소드로 파일을 더 읽어올 수 있는지 판단하는 메소드
                members.add(new Member(dis.readUTF(), dis.readUTF(), dis.readInt())); // 입력한 순서대로 읽기
            }
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            return new ArrayList<>();
//            return List.of(); 를 쓰는게 더 좋긴함
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
}
