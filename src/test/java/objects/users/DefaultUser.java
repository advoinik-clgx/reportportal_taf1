package objects.users;

public final class DefaultUser extends AbstractUser {
    public DefaultUser() {
        login = "default";
        password = "1q2w3e";
        role = Role.USER;
    }
}
