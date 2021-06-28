import config.TransactionManagerConfig;
import config.WebConfig;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.UserService;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TransactionManagerConfig.class, WebConfig.class})
public class UserServiceTest {
    private static final Integer MIN_AGE = 18;
    private static final Integer MAX_AGE = 60;
    private static final Long USER_ID = 1L;

    @Autowired
    public UserService service;

    @Test
    public void getByAgeExcluding() {
        List<User> users = service.getByAgeExcluding(MIN_AGE, MAX_AGE);
        assertNotEquals(0, users.size());
    }

    @Test
    public void getByAgeIncluding() {
        List<User> users = service.getByAgeIncluding(MIN_AGE, MAX_AGE);
        assertNotEquals(0, users.size());
    }

    @Test
    public void getById() {
        User user = service.getById(USER_ID);
        assertNotNull(user);
    }

    @Test
    public void getByGroups() {

    }

    @Test
    public void getByName() {
    }
}
