package objects.users;

public final class DefaultSuperAdmin extends AbstractUser {
    public DefaultSuperAdmin() {
        login = "superadmin";
        password = "erebus";
        role = Role.SUPERADMIN;
    }
}
