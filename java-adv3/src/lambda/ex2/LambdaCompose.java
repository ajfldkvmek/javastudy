package lambda.ex2;

public class LambdaCompose {

    @FunctionalInterface
    public interface MyTransformer<T> {
        T transform(T t);
    }

    public static <T> MyTransformer<T> compose(MyTransformer<T> f1, MyTransformer<T> f2) {
        return t -> f2.transform(f1.transform(t));
    }

    public static void main(String[] args) {
        String str = "hello";

//        MyTransformer<String> f1 = s -> "***" + s + "***";
//        MyTransformer<String> f2 = String::toUpperCase;
//        String result = compose(f1, f2).transform(str);

        String result =
                LambdaCompose.<String>compose(s1 -> "***" + s1 + "***", String::toUpperCase).transform(str);


        System.out.println("result = " + result);
    }
}
