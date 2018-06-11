package service;

import exception.NotVotingTimeException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static service.RestaurantTestData.EVRASIA_ID;
import static service.RestaurantTestData.ULIBKA_ID;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class VoteServiceImplTest {

    @Autowired
    private VoteService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        if(!(LocalTime.now().isBefore(LocalTime.of(11,00)) && LocalTime.now().isAfter(LocalTime.of(11,00))))
        {
            return;
        }
        service.create(100003, EVRASIA_ID);
    }

    @Test
    public void delete() throws Exception {
        service.delete(100003);
    }

    @Test
    public void getAll() throws Exception {
        service.getAll().stream().forEach(System.out::println);
    }

    @Test(expected = NotVotingTimeException.class)
    public void createNotVotingTime()
    {
       // service.delete(100003);
        service.create(100003,100003);
    }

}