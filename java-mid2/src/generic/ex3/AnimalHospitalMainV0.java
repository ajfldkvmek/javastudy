package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {

    public static void main(String[] args) {

        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("댕댕이1", 100);
        Cat cat = new Cat("고먐미", 300);

        dogHospital.set(dog);
        dogHospital.checkup();

        catHospital.set(cat);
        catHospital.checkup();

       // dogHospital.set(cat);

        Dog biggerDog = dogHospital.bigger(new Dog("댕댕이2", 500));
        System.out.println("biggerDog = " + biggerDog);

    }
}
