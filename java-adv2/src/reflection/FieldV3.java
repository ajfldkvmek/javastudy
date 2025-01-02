package reflection;

import reflection.data.Team;
import reflection.data.User;

/**
 *
 *  리플랙션은 코드의 재사용성도 떨어트리고 안정성도 떨어트리게 된다.
 *  그렇기 때문에 거의 사용하지 않는다.
 *  (프레임워크나 API 등을 만들 때 사용함)
 *
 *  예를 들어 아래 코드와 같이 null 값이 있을 경우 ""로 값을 변경한다 하였을 때,
 *  모든 경우의 수를 다 체크해야하는 일이 발생할 수 있다.
 *  -> FiledV4/FieldUtil 를 보자
 */
public class FieldV3 {

    public static void main(String[] args) {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("======= before ==========");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        if (user.getId() == null) {
            user.setId("");
        }

        if (user.getName() == null) {
            user.setName("");
        }

        if (user.getAge() == null) {
            user.setAge(0);
        }

        if (team.getId() == null) {
            team.setId("");
        }

        if (team.getName() == null) {
            team.setName("");
        }

        System.out.println("========== after ==========");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
