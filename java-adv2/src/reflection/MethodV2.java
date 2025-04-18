package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //정적 메소드 호출 - 일반 메소드 호출
        BasicData helloInstance = new BasicData();
        helloInstance.call();   //코드를 변경하지 않는 이상 정적이다


        //동적 메소드 호출
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName = "hello";


        //메소드 이름을 변수로 변경할 수 있따.
        //ex. 콘솔창을 통해 methodName 을 입력받는 경우
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class);
        System.out.println("method1 = " + method1);

        Object returnValue = method1.invoke(helloInstance, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
