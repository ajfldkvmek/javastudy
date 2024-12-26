package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

    /**
     *  Wildcard 는 이미 만들어진 제네릭타입을 사용할 때
     *  좀 더 편하게 활용하기 위해서 사용한다.
     *
     *  둘다 비슷한 기능을 하지만
     *
     *  메소드를 제네릭타입으로 선언하느냐
     *
     *  일반 메소드로 선언하여 사용하느냐
     *
     *  그럼 '?' 의 의미는? >>> Object  를 의미한다고 보면됨
     *  
     *  
     *  ps. 제네릭이 꼭 필요한 것이 아니라면 제네릭 보다는 와일드카드의 사용을 권장함
     *      제네릭이 꼭 필요한 경우: 타입 매개변수가 필요할 때 ( printAndReturnWildcard 를 참고하도록 하자)
     *      
     *
     */
    
    //제네릭 메소드
    static <T> void printGenericV1(Box<T> box){
        System.out.println("T = " + box.get());
    }

    //일반 메소드 -> 일반메소드 임에도 와일드카드를 사용하여 제네릭처럼 사용할 수 있음
    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    static <T extends Animal> void printGenericV2(Box<T> box){
        T t = box.get();
        System.out.println("이름 = " + t.getName());
    }


    static void printWildcardV2(Box<? extends Animal> box){
        Animal animal =  box.get();
        System.out.println("이름 = " + animal.getName());
    }


    static <T extends Animal> T printAndReturnGeneric(Box<T> box){
        T t = box.get();
        System.out.println("이름 = " + t.getName());
        return t;
    }


    /**
     *  이렇게 와일드카드로 매개변수를 지정하게 되면
     *  반환값이 'Animal' 이기 때문에 cat 을 전달하던 dog 를 전달하던 항상 Animal로 반환되기 때문에
     *  캐스팅을 추가로 해줘야 할 일이 생긴다.
     */
    static Animal printAndReturnWildcard(Box<? extends Animal> box){
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }

}
