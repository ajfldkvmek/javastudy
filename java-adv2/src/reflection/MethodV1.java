package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {

        Class<BasicData> helloClass = BasicData.class;

        System.out.println("========== methods() ===========");
        //getMethods() 는 public 메소드만 찾아준다
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        //클래스에 선언한 모든 메소드를 찾아준다
        System.out.println("=========== declareMethod() =============");
        Method[] declareMethods = helloClass.getDeclaredMethods();
        for (Method declareMethod : declareMethods) {
            System.out.println("declareMethod = " + declareMethod);
        }
    }
}
