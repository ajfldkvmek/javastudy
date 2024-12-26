package collection.deque.test.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {

    public static void main(String[] args) {
        Map<String , String> dic = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("===단어 입력 단계===");
        while (true){
            System.out.println("영어단어를 입력하세요(종료하려면 'q' 입력)");
            String eng = sc.nextLine();

            if(eng.equalsIgnoreCase("q")){
                break;
            }

            System.out.println("한글 뜻 입력");
            String kor = sc.nextLine();

            dic.put(eng, kor);
        }

        System.out.println("===단어 검색 단계===");
        while(true) {
            System.out.println("찾을 단어를 입력하시오");
            String searchWord = sc.nextLine();
            if(searchWord.equalsIgnoreCase("q")){
                break;
            }

            if(dic.containsKey(searchWord)){
                String findWord = dic.get(searchWord);
                System.out.println(searchWord + "의 뜻은 " + findWord + "입니다.");
            } else {
                System.out.println(searchWord + "는 사전에 없는 단입니다.");
            }
        }
        System.out.println("===     종료     ===");
    }
}
