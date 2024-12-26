package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printGenericV2(dogBox);

        WildcardEx.printWildcardV1(dogBox);
        WildcardEx.printWildcardV2(dogBox);

        WildcardEx.printAndReturnGeneric(dogBox);

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);


        /**
         *  와일드 카드로 선언했기 때문에 특성 타입으로 반환받기 위해서 캐스팅이 추가로 필요
         */
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);
        Dog doggy =(Dog) WildcardEx.printAndReturnWildcard(dogBox);

    }
}
