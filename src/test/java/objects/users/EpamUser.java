package objects.users;

public class EpamUser extends User {
    public EpamUser() {
        login = System.getenv("user");
        password = System.getenv("password");
        role = Role.USER;
    }
}
