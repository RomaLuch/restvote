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

import static org.junit.Assert.*;
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

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
        List<Menu> all = service.getAll(ULIBKA_ID);

        all.stream().forEach(System.out::println);
    }

    @Test
    public void update() throws Exception {

    }

}