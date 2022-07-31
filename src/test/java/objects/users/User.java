package objects.users;

import lombok.Getter;

@Getter
public class User {
    String login;
    String password;
    Role role;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
