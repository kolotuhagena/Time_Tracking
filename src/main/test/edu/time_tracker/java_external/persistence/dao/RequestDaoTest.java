package edu.time_tracker.java_external.persistence.dao;

import edu.time_tracker.java_external.persistence.entity.Activity;
import edu.time_tracker.java_external.persistence.dao.Factory.Factory;
import edu.time_tracker.java_external.persistence.entity.Request;
import edu.time_tracker.java_external.persistence.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RequestDaoTest {
    private Request request;
    private RequestDao requestDao;
    @Before
    public void setUp() throws Exception {
        requestDao= new Factory().getRequestDao();
        request = new Request();
        request.setRequestId(1);
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("sleep");
        request.setActivity(activity);
        User user = new User();
        user.setUserId(1);
        user.setLogin("anAccount");
        user.setPassword(145144);
        user.setEmail("hghhr@add.ua");
        user.setRole("USER");
        request.setUser(user);
        request.setType("ADD");
    }

    @After
    public void tearDown() throws Exception {
        requestDao.delete(request.getRequestId());
        request=null;
        requestDao=null;

    }

    @Test
    public void create() {
        requestDao.create(request);
        Assert.assertEquals(request, requestDao.getById(request.getRequestId()));
    }

    @Test
    public void getById() {
        requestDao.create(request);
        request = requestDao.getById(request.getRequestId());
        Assert.assertNotNull(request);
    }

    @Test
    public void update() {
        requestDao.create(request);
        request.setType("DELETE");
        requestDao.update(request, request.getRequestId());
        Assert.assertEquals(request, requestDao.getById(request.getRequestId()));
    }

    @Test
    public void delete() {
        requestDao.create(request);
        Assert.assertNotNull(requestDao.getById(request.getRequestId()));
        requestDao.delete(request.getRequestId());
        Assert.assertNull(requestDao.getById(request.getRequestId()));
    }

    /*@Test
    public void getAll() {
        requestDao.create(request);
        List<Request> list;
        list = requestDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()>0);
    }*/
}