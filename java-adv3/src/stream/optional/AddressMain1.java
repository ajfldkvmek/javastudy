package stream.optional;

import stream.optional.model.Address;
import stream.optional.model.User;

public class AddressMain1 {

    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        String street = getUserStreet(user);
        if(street != null) {
            System.out.println(street);
        } else {
            System.out.println("unknown");
        }
    }

    // 예시를 위한 메소드
    static String getUserStreet(User user) {
        if (user == null) {
            return null;
        }
        if (user.getAddress() == null) {
            return null;
        }
        return user.getAddress().getStreet();
    }

}
