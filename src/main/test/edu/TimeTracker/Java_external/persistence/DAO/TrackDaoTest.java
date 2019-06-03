package edu.timeTracker.java_external.domain.DAO;

import edu.timeTracker.java_external.domain.entity.Activity;
import edu.timeTracker.java_external.domain.entity.Track;
import org.junit.*;

import java.sql.Time;
import java.util.List;


public class TrackDaoTest {
    private Track track;
    private TrackDao trackDao;
    @Before
    public void setUp() throws Exception {
        track= new Track();
        track.setTrackID(1);
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("sleep");
        track.setActivity(activity);
        track.setActive(true);
        track.setCompleted(false);
        track.setElapsedTime(new Time(1000));
        trackDao= new Factory().getTrackDao();
    }

    @After
    public void tearDown() throws Exception {
        trackDao.delete(track.getTrackID());
        track=null;
        trackDao=null;
    }

    @Test
    public void getById() {
        trackDao.create(track);
        track = trackDao.getById(1);
        Assert.assertNotNull(track);
    }

    @Test
    public void create() {
        trackDao.create(track);
        Assert.assertEquals(track,trackDao.getById(track.getTrackID()));
    }

    @Test
    public void update() {
        trackDao.create(track);
        track.setElapsedTime(new Time(2000));
        trackDao.update(track, track.getTrackID());
        Assert.assertEquals(track, trackDao.getById(track.getTrackID()));
    }

    @Test
    public void delete() {
        trackDao.create(track);
        track=trackDao.getById(track.getTrackID());
        trackDao.delete(track.getTrackID());
        Assert.assertNotEquals(track, trackDao.getById(track.getTrackID()));
    }

   /* @Test
    public void getAll() {
        trackDao.create(track);
        List<Track> list;
        list = trackDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()>0);
    }*/
}