package service;

import model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static service.MenuTestData.*;
import static service.RestaurantTestData.ULIBKA;
import static service.RestaurantTestData.ULIBKA_ID;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class MenuServiceImplTest {

    @Autowired

    MenuService service;

    @Test
    public void create() throws Exception {
        Menu menu = new Menu(null, "New", 0);
        Menu created = service.create(menu, ULIBKA_ID);
        menu.setId(created.getId());
        assertMatch(service.getAll(ULIBKA_ID), ULIBKA_MENU_1, ULIBKA_MENU_2, ULIBKA_MENU_3, menu);
    }

    @Test
    public void delete() throws Exception {
        service.delete(100012);
        service.delete(100013);
        assertMatch(service.getAll(ULIBKA_ID), ULIBKA_MENU_1);
    }

    @Test
    public void get() throws Exception {
        assertMatch(service.get(SOLYANKA_ID),ULIBKA_MENU_1);
    }

    @Test
    public void getAll() throws Exception {
        List<Menu> all = service.getAll(ULIBKA_ID);
        assertMatch(all, ULIBKA_MENU_1, ULIBKA_MENU_2, ULIBKA_MENU_3);
    }

    @Test
    public void update() throws Exception {
        Menu updated = new Menu (ULIBKA_MENU_1);
        updated.setName("NEW MENU");
        updated.setRestaurant(ULIBKA);
        service.update(updated);
        assertMatch(service.get(SOLYANKA_ID), updated);
    }

}