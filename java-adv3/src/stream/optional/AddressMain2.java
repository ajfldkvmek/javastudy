package stream.optional;

import stream.optional.model.Address;
import stream.optional.model.User;

import java.util.Optional;

public class AddressMain2 {

    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    // to inline variable -> option + cmd + N (mac)
    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
                x -> System.out.println(x),         //값이 있으면 그 값을 출력
                () -> System.out.println("unknown street")//없으면 unknown을 출력
        );
    }

    // Optional 반환
    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user) // user 가 null 일 수 있으므로 ofNullable 사용
                .map(User::getAddress)
                .map(address -> address.getStreet());
        // map 체이닝 중간에 null 이면 Optional.empty() 를 반환함
    }

}
