package service;

import model.Role;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static service.UserTestData.*;

/**
 * Created by RLuchinsky on 21.05.2018.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceImplTest {

    @Autowired
    private UserService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", Collections.singleton(Role.ROLE_USER));
        User created = service.create(newUser);
        newUser.setId(created.getId());
        assertMatch(service.getAll(), USER, ADMIN, newUser);
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_ID);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID);
        assertMatch(user, USER);
    }

    @Test
    public void getByEmail() throws Exception {
        User user = service.getByEmail("user@yandex.ru");
        assertMatch(user, USER);
    }

    @Test
    public void update() throws Exception {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        service.update(updated);
        assertMatch(service.get(USER_ID), updated);
    }

    @Test
    public void getAll() throws Exception {

        List<User> all = service.getAll();
        assertMatch(all, USER, ADMIN);
    }

}