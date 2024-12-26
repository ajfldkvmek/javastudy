package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {

        char charA = 'A';
        char charB = 'B';

        System.out.println("charA>>" + charA);
        System.out.println("charB>>" + charB);

        int hashCode = hashCode("A");
        System.out.println("hashCode::" + hashCode);

        System.out.println("hashIndex(hashCode(\"A\")) = " + hashIndex(hashCode("A")));
//        int hashIndexA = hashCode("A");
//        int hashCodeA = hashIndex(hashIndexA);

        //hashCode
        System.out.println("hashCodeA::" + hashCode("A"));
        System.out.println("hashCodeB::" + hashCode("B"));
        System.out.println("hashCodeAB::" + hashCode("AB"));

        //hashIndex
        System.out.println("hashIndexA::" + hashIndex(hashCode("A")));
        System.out.println("hashIndexB::" + hashIndex(hashCode("B")));
        System.out.println("hashIndexAB::" + hashIndex(hashCode("AB")));

    }

    static int hashCode(String str){
        int sum = 0;
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
    }

    static int hashIndex(int value){
        return value % CAPACITY;
    }
}
