package collection.compare.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {

        /**
         *  of 메소드를 사용하여 객체를 생성하면 
         *  Immmutable로 생성되기 때문에 기본적으로 값의 변경이 불가하다
         *  
         *  ps. of메소드의 경우 java 9 이상부터 새로 추가된 메소드이므로(9 이상부터는 of 사용권장)
         *  이전버전에서는 asList를 사용해야함 ( List<Integer> list = Arrays.asList(1,2,3); )
         *  하지만 이 경우 길이는 고정이지만 값의 변경은 가능하다는 점에서 완전한 불변성은 아님
         *  
         *  이 두 메소드 모드 배열을 생성한 후 미 배열을 매개변수로 전달하여 생성할 수도 있음
         *  
         *  둘의 차이점은 
         *  
         *  asList는 전달받은 배열을 그대로 사용하여 생성
         *  of는 배열을 탐색하여 재사용하여 생성
         *
         *  매우 큰 배열을 상용할 경우 asList가 속도면에서 유리할 수 있음
         */
        //immutable
        List<Integer> list = List.of(1,2,3);

        //immutable로 mutable 생성
        List<Integer> ll = new ArrayList<>(list);
        
        //아래와 같이 Collections.unmodifiableList(ll)을 통해 생성하게 되면
        //이 또한 불변객체로 생성됨(이미 만들거진 데이터를 불변으로 바꾸고 싶을 때 사용)
        List<Integer> ml = Collections.unmodifiableList(ll);
//        ml.add(3);
        
    }
}
