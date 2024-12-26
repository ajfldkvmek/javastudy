package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {

    public static void main(String[] args) {

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("애옹스", 100);

        AnimalMethod.checkup(dog);
        AnimalMethod.checkup(cat);

    }

}
