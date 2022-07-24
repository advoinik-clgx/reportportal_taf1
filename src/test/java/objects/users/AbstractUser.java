package objects.users;

public class AbstractUser {
    String login;
    String password;
    Role role;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
