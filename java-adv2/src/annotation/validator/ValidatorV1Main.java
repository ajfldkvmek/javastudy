package annotation.validator;

import static util.MyLogger.log;

public class ValidatorV1Main {

    public static void main(String[] args) {

        User user = new User("user1", 0);
        Team team = new Team("", 0);


        try {
            log(" === User 검증 === ");
            validateUser(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log(" === Team 검증 === ");
            validateTeam(team);
        } catch (Exception e) {
            log(e);
        }


    }

    private static void validateTeam(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new RuntimeException("이름이 비었어!!!!!!!!!!");
        }

        if (team.getMemberCount() < 1 || team.getMemberCount() > 999) {
            throw new RuntimeException("회원수는 1과 999 사이!");
        }
    }

    private static void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("이름이 비었어!!!!!!!!!!");
        }

        if (user.getAge() < 1 || user.getAge() > 100) {
            throw new RuntimeException("나이는 1과 100 사이로 입력해줘");
        }
    }

}
