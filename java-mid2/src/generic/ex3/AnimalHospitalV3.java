package generic.ex3;

import generic.animal.Animal;

// 아래와 같이 제네릭을 사용하되 관련된 타입만 받을 수 있도록 한정자를 설정할 수 있따.
public class AnimalHospitalV3<T extends Animal> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    //T 의 타입은 메서드 정의 시점에는 알 수가 없음
    //하지만 한정자를 지정하여 제네릭을 설정할 경우 
    //하위 메소드들을 사용할 수 있음
    public void checkup(){
        System.out.println("동물이름: " + t.getName());
        System.out.println("동물크기: " + t.getSize());
        t.sound();
        t.toString();
        t.equals(null);
    }


    public Animal bigger(Animal target){
        return t.getSize() > target.getSize() ? t : target;
    }
}
