package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testUserDao {
    User user = new User();

    // OK
    @Test
    public void test() {
        user.setUsername("root");
        user.setPassword("898989");

        UserDao userDao = new UserDao();
        User user = userDao.loginUser(this.user);

        assertEquals(null, user);
    }

}
