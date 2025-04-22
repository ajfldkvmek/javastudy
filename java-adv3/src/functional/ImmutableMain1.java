package functional;

public class ImmutableMain1 {

    public static void main(String[] args) {

        // mutable
        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = m1;
        m2.setAge(20);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);


        // immutable
        ImmutablePerson i1 = new ImmutablePerson("Kim", 10);
        ImmutablePerson i2 = i1.withAge(30);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);


    }

}
