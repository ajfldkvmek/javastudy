package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

    public static void main(String[] args) {

        AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
        AnimalHospitalV1 catHospital = new AnimalHospitalV1();

        Dog dog = new Dog("댕댕이1", 100);
        Cat cat = new Cat("고먐미", 300);

        dogHospital.set(dog);
        dogHospital.checkup();

        catHospital.set(cat);
        catHospital.checkup();

        
        //dogHospital.set(cat); //Animal로 받기 때문에 타입체크 오류가 발생하지 않음


        //Animal 타입을 반환하기 때문에 Dog를 받기위해서는 캐스팅을 하여 받아야함
        Dog biggerDog = (Dog) dogHospital.bigger(new Dog("댕댕이2", 500));
        System.out.println("biggerDog = " + biggerDog);

    }
}
