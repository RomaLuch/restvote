package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

/**
 * Created by RLuchinsky on 18.05.2018.
 */
public class User extends AbstractNamedEntity{

    private String email;

    private String password;

    private Set<Role> roles;

    private int rest_Id;

/*    protected User(Integer id, String name) {
        super(id, name);
    }*/

    public User(Integer id, String name, String email, String password, Set<Role> roles, int rest_Id) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.rest_Id = rest_Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getRest_Id() {
        return rest_Id;
    }

    public void setRest_Id(int rest_Id) {
        this.rest_Id = rest_Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", rest_Id=" + rest_Id +
                ", name='" + name + '\'' +
                '}';
    }
}
