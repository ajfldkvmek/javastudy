package generic.ex5;

public class __타입이레이저 {

    /**
     *  제네릭을 선언할 때 상한제한을 하지 않으면 컴파일 후 자동으로 Object 로 설정되어 제네릭이 사라진다고 생각하면됨
     *
     *  그래서 컴파일 될 때 상한제한 없이 제네릭으로 설정한 경우 자바 컴파일러가 캐스팅 코드를 추가해줌
     *
     *  ex)
     *      GenericBox box = new GenericBox();
     *      box.set(10);
     *      Integer result = (Integer) box.get();  //컴파일러가 추가한 캐스팅
     *      
     *      만약 상한을 지정해준다면?
     *      컴파일 후 전부 상한으로 지정해준 타입으로 바뀜
     *      
     *      즉 제네릭타입은 컴파일타임까지만 존재하고
     *      런타임시에는 사라지게 되는데 이를 타입이레이저라고 한다.
     *      >> "런타임에 타입을 활용하는 코드는 사용할 수 없다" >>> EraserBox 참고
     *
     */
}
