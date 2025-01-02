package reflection;

import reflection.data.Team;
import reflection.data.User;

import static reflection.FieldUtil.nullFiledToDefault;

/**
 *  일반적으로 리플랙션을 사용하지는 않지만
 *  다음과 같이 공통으로 로직을 해결하고자 할 때 리플랙션을 사용하여 처리할 수 있다.
 */
public class FieldV4 {

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("======== before ============");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        System.out.println("============= after ===============");
        nullFiledToDefault(user);
        nullFiledToDefault(team);

        System.out.println("user = " + user);
        System.out.println("team = " + team);

    }
}
