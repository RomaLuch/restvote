package service; /**
 * Created by RLuchinsky on 21.05.2018.
 */
import model.Role;
import model.User;

import java.util.Arrays;

import static model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;


public class UserTestData {
    public static final int USER_ID = START_SEQ + 3;
    public static final int ADMIN_ID = START_SEQ + 4;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "roles");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("roles").isEqualTo(expected);
    }
}
