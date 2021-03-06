package edu.time_tracker.java_external.persistence.dao;

import edu.time_tracker.java_external.persistence.dao.Factory.DAOFactory;
import edu.time_tracker.java_external.persistence.dao.Factory.Factory;
import edu.time_tracker.java_external.persistence.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    private DAOFactory daoFactory;
    private UserDao userDao;

    @Before
    public void setUp() {
        daoFactory= new Factory();
        userDao=daoFactory.getUserDao();
    }
    @After
    public void close() {
        daoFactory = null;
        userDao = null;
    }

    @Test
    public void getByIncorrectIdReturnNull() {
        User user;
        user = userDao.getById(-1);
        Assert.assertNull(user);
    }

    /*@Test
    public void getAll() {
        List<User> list;
        list = userDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()>0);
    }*/

    /**
     * Test of creating an user.
     * If you run 2 times
     */
    @Test
    public void create() {
        User user = new User();
        int id=2;
        user.setUserId(id);
        user.setLogin("login");
        user.setPassword(12345);
        user.setEmail("login@some.ua");
        userDao.create(user);
        User user2= userDao.getById(id);
        Assert.assertTrue(user2.equals(user));
        userDao.delete(id);
    }

    @Test
    public void update() {
        User user;
        int id=1;
        user=userDao.getById(id);
        user.setLogin("anAccount");
        userDao.update(user,id);
        Assert.assertTrue(user.equals(userDao.getById(id)));
    }

    @Test
    public void delete() {
        User user = userDao.getById(1);
        user.setLogin("another");
        user.setUserId(2);
        userDao.create(user);
        Assert.assertTrue(user.equals(userDao.getById(2)));
        userDao.delete(2);
        Assert.assertNull(userDao.getById(2));

    }
}