package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {

    public static void main(String[] args) {

        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3();

        Dog dog = new Dog("댕댕이1", 100);
        Cat cat = new Cat("고먐미", 300);

        dogHospital.set(dog);
        dogHospital.checkup();

        catHospital.set(cat);
        catHospital.checkup();

        //제네릭으로 타입을 지정하였기 때문에 다른 타입을 받을 수 없음
        //dogHospital.set(cat);


        //Animal 타입을 반환하기 때문에 Dog를 받기위해서는 캐스팅을 하여 받아야함
        Dog biggerDog = (Dog) dogHospital.bigger(new Dog("댕댕이2", 500));
        System.out.println("biggerDog = " + biggerDog);

    }
}
