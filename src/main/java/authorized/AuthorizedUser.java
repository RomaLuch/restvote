package authorized;

import model.Role;

import java.util.HashSet;
import java.util.Set;

import static model.Role.ROLE_ADMIN;
import static model.Role.ROLE_USER;

public class AuthorizedUser {

    private static Set<Role> roles = new HashSet<>();

    private static int id = 100004;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    static
    {
        roles.add(ROLE_ADMIN);
        roles.add(ROLE_USER);
    }

    public static Set<Role> getRoles() {
        return roles;
    }

    public static void setRoles(Set<Role> roles) {
        AuthorizedUser.roles = roles;
    }


}
