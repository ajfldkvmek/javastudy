package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning() {
        //사용되지 않는 변수 경고 억제
        int unusedVariable = 10;
    }

    @SuppressWarnings("deprecated")
    public void deprecatedMethod() {
        Date date = new Date();
        //getDate 의 경우 현재는 사용하지 않는 것을 권장하기 때문에 경고가 발생한다.
        int date1 = date.getDate();
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast() {
        //제네릭 타입 캐스팅 경고 억제, raw type 사용 경고
        List list = new ArrayList();

        List<String> stringList = (List<String>) list;
    }

    @SuppressWarnings("all") //모든 경고 억제
    public void suppressAllWarning() {
        Date date = new Date();
        int date1 = date.getDate();
        List list = new ArrayList();
        List<String> stringList = (List<String>) list;
    }

}
