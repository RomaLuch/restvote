package service;

import model.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static service.RestaurantTestData.*;


/**
 * Created by RLuchinsky on 21.05.2018.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RestaurantServiceImplTest {

    @Autowired
    RestaurantService service;

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

        List<Restaurant> all = service.getAll();
        assertMatch(all, TOKIO, EVRASIA, ULIBKA);
    }

    @Test
    public void update() throws Exception {

    }

}