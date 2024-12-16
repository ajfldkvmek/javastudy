package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        writeBox(objBox);
        writeBox(animalBox);

        /**
         *  하한을 Animal 로 설정하였기 때문에
         *  Dog 와 Cat 을 받을 수 없음( Animal 의 하위타입 )
         */
//        writeBox(dogBox);
//        writeBox(catBox);

    }

    /**
     *  와일드카드로 하한을 설정
     *  하한설정은 제네릭에서는 사용이 불가하고
     *  와일드카드에서만 설정이 가능함
     */
    static void writeBox(Box<? super Animal> box) {
        box.set(new Dog("멈멈미", 100));
    }

}
