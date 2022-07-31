package objects.users;

public final class DefaultSuperAdmin extends User {
    public DefaultSuperAdmin() {
        login = "superadmin";
        password = "erebus";
        role = Role.SUPERADMIN;
    }
}
