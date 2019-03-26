package edu.TimeTracker.Java_external.persistence.DAO;

import edu.TimeTracker.Java_external.persistence.entity.Activity;
import edu.TimeTracker.Java_external.persistence.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao implements GenericDao<Activity> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void create(Activity activity) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLActivity.CREATE.getQUERY())) {
            statement.setInt(1,activity.getActivityId());
            statement.setString(2,activity.getName());
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Activity " + activity.getName() + " was created");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public Activity getById(int key){
        Activity activity=null;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLActivity.SELECT_BY_ID.getQUERY())){
            statement.setInt(1,key);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) return null;
            activity = new Activity();
            activity.setActivityId(resultSet.getInt("activity_id"));
            activity.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
        return activity;
    }

    @Override
    public Activity getByName(String login) {
        return null;
    }

    @Override
    public void update(Activity activity, int id){
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLActivity.UPDATE.getQUERY())){
            statement.setInt(3,id);
            statement.setInt(1,activity.getActivityId());
            statement.setString(2,activity.getName());
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Activity " + activity.getName() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public void delete(int id){
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLActivity.DELETE.getQUERY())){
            statement.setInt(1,id);
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Activity with " + id + " was deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public List<Activity> getAllWithPagination(int offset, int recordPerPage){
        List<Activity> list = new ArrayList<>();
        Activity activity;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLActivity.SELECT_ALL_WITH_LIMITS.getQUERY())){
            statement.setInt(1,offset);
            statement.setInt(2,recordPerPage);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                activity = new Activity();
                activity.setActivityId(resultSet.getInt("activity_id"));
                activity.setName(resultSet.getString("name"));
                list.add(activity);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
        return list;
    }

    @Override
    public int getCountObjects() {
        return 0;
    }


    enum SQLActivity{
        SELECT_BY_ID("SELECT * FROM activity WHERE activity_id=?"),
        SELECT_ALL_WITH_LIMITS("SELECT * FROM activity LIMIT ?,?"),
        CREATE("INSERT INTO activity (activity_id, name) VALUES(?,?)"),
        UPDATE("UPDATE activity SET activity_id=?, name=? WHERE activity_id=?"),
        DELETE("DELETE FROM activity WHERE activity_id=?");


        private String QUERY;

        SQLActivity(String query) {
            this.QUERY = query;
        }

        public String getQUERY() {
            return QUERY;
        }
    }
}
