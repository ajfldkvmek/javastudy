package generic.ex1;

public class RowTypeMain {

    //제네릭을 지정해주지 않는 것을 rowtype(원시타입) 이라고 한다.
    //이런식으로 rowtype을 사용하지말고
    GenericBox integerBox = new GenericBox();
   // integerBox.set(10);

    
    //아래처럼 Object을 사용하도록 하자
    GenericBox<Object> objectBox = new GenericBox();

    //그럼에도 불구하고 rowtype을 사용하는 이유는
    //자바의 제네릭은 자바 출시 후 시간이 지난 후에 나왔기때문에
    //하위버전에서는 사용하지 못하는 경우가 있따 <<< 근데 웬만하면 다 사용가능하기 떄문에 사용하지 않는 것을 권고
    
}
