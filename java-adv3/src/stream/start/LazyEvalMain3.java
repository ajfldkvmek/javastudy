package stream.start;

import lambda.lambda4.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain3 {

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex2(List<Integer> data) {
        System.out.println("MyStreamV3 시작");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                })
                .getFirst();

        System.out.println("result = " + result);
    }

    //자바의 stream api 는 파이프라인 방식이다.
    private static void ex1(List<Integer> data) {
        Integer result = data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                })
                .findFirst().get();
                //findFirst 는 Optional 이라는 타입을 반환한다. 따라서 결과값을 얻으려면 get() 메소드가 추가로 필요
                //자바의 findFirst 는 지연연산 + 파이프라인 을 사용한 "단축 평가" 라고 한다.
                // ** 지연연산: 최종연산이 호출되기 전까지 실제 연산은 일어나지 않음
        System.out.println("result = " + result);
        
    }

}
