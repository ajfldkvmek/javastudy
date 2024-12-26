package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/member-test.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        //charset 은 생략 가능 - 생략시 os 기본 인코딩 방식으로 지정됨
        //true 면 기존에 파일 있으면 덮어쓰지 않고 추가로 데이터 입력함
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, StandardCharsets.UTF_8, true))) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
            //이 경우 close 자동으로 호출
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] memberDate = line.split(DELIMITER);
                members.add(new Member(memberDate[0], memberDate[1], Integer.valueOf(memberDate[2])));
            }
        } catch(FileNotFoundException e){
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
}
