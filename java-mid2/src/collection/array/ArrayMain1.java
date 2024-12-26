package collection.array;

public class ArrayMain1 {

    public static void main(String[] args) {
        int[] arr= new int[5];
        
        //배열의 인덱스를 지정하여 값을 저장 하는 시간복잡도는 O(1) 의 값을 가진다
        //하지만 배열에 이미 데이터가 입력된 상태에서 데이터를 삽입하며
        //이후 인덱스의 데이터를 유지하기위해 크기를 늘려 가장앞에 데이터를 입력할 경우 O(n)의 복잡도를 가진다
        //마지막인덱스에 추가할 경우 여전히 O(1)
        System.out.println("==index 입려기 O(1) == ");
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

    }
}
