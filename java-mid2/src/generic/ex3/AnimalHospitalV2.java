package generic.ex3;

import generic.animal.Animal;

public class AnimalHospitalV2<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    //T 의 타입은 메서드 정의 시점에는 알 수가 없음
    public void checkup(){
//        System.out.println("동물이름: " + t.getName());
//        System.out.println("동물크기: " + t.getSize());
//        t.sound();
        t.toString();
        t.equals(null);
    }


    public T bigger(Animal target){
        //return t.getSize() > target.getSize() ? t : target;
        return null;
    }
}
