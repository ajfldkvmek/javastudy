package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        
        /// 처럼 제네릭을 그냥 사용해버리면 관련없는
        // Inetger 이나 Object도 다 받아버릴 수 있다
        // 즉 제네릭을 사용하면서도 관련 타입들만 받을 수 있도록 해야한다
        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2();
        AnimalHospitalV2<Integer> integerHospital = new AnimalHospitalV2();
        AnimalHospitalV2<Object> objectHospital = new AnimalHospitalV2();

        

    }
}
