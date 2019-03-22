package edu.TimeTracker.Java_external.entity.DAO;

import edu.TimeTracker.Java_external.entity.Activity;
import edu.TimeTracker.Java_external.entity.DAO.Factory.DAOFactory;
import edu.TimeTracker.Java_external.entity.DAO.Factory.Factory;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class ActivityDaoTest {
    private   ActivityDao activityDao;
    private  Activity activity;

    @Before
    public  void  setUp() throws Exception {

        activityDao= new Factory().getActivityDao();
        activity=new Activity();
        activity.setActivityId(2);
        activity.setName("wakeup");
    }

    @After
    public  void tearDown() throws Exception {
        activityDao.delete(activity.getActivityId());
        activity=null;
        activityDao=null;

    }

    @Test
    public void create() {
        activityDao.create(activity);
        Assert.assertTrue(activity.equals(activityDao.getById(activity.getActivityId())));
    }

    @Test
    public void getById() {
        activityDao.create(activity);
        assertEquals(activity, activityDao.getById(activity.getActivityId()));
    }

    @Test
    public void update() {
        activityDao.create(activity);
        activity.setName("makeup");
        activityDao.update(activity,activity.getActivityId());
        assertEquals(activity, activityDao.getById(activity.getActivityId()));

    }


    @Test
    public void getAll() {
        activityDao.create(activity);
        List list = activityDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void delete() {
        activityDao.create(activity);
        Assert.assertNotNull(activityDao.getById(activity.getActivityId()));
        activityDao.delete(activity.getActivityId());
        Assert.assertNull(activityDao.getById(activity.getActivityId()));
    }
}