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

import static service.RestaurantTestData.EVRASIA_ID;
import static service.RestaurantTestData.ULIBKA_ID;

/**
 * Created by RLuchinsky on 30.05.2018.
 */

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
        Assert.assertEquals((long)0, (long)service.countByRestaurantId(EVRASIA_ID));
        service.create(100003, EVRASIA_ID);
        Assert.assertEquals((long)1, (long)service.countByRestaurantId(EVRASIA_ID));
    }

    @Test
    public void delete() throws Exception {
        service.delete(100003);
        Assert.assertEquals((long)1, (long)service.countByRestaurantId(ULIBKA_ID));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals((long)2, (long)service.countByRestaurantId(ULIBKA_ID));
    }

    @Test(expected = NotVotingTimeException.class)
    public void createNotVotingTime()
    {
       // service.delete(100003);
        service.create(100003,100003);
    }

}