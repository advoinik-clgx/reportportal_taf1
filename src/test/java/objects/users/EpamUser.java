package objects.users;

public class EpamUser extends AbstractUser {
    public EpamUser() {
        login = System.getenv("user");
        password = System.getenv("password");
        role = Role.USER;
    }
}
