package authorized;

import model.Role;

import java.util.HashSet;
import java.util.Set;

import static model.Role.ROLE_ADMIN;
import static model.Role.ROLE_USER;

public class AuthorizedUser {

    private static Set<Role> roles = new HashSet<>();

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
/*
    public static boolean containAdmin(Set<Role> roles)
    {
        return  roles.contains(ROLE_ADMIN);
    }*/

}
