package edu.TimeTracker.Java_external.entity.DAO;

import edu.TimeTracker.Java_external.entity.Activity;
import edu.TimeTracker.Java_external.entity.util.ConnectionPool;
import edu.TimeTracker.Java_external.entity.util.SimpleConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao implements GenericDao<Activity> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void create(Activity activity) {
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
    public void update(Activity activity, int id){
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
    public List<Activity> getAll(){
        List<Activity> list = new ArrayList<>();
        Activity activity;
        try(Connection connection = SimpleConnection.getInstance().getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQLActivity.SELECT_ALL.getQUERY());
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

    enum SQLActivity{
        SELECT_BY_ID("SELECT * FROM activity WHERE activity_id=?"),
        SELECT_ALL("SELECT * FROM activity"),
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
