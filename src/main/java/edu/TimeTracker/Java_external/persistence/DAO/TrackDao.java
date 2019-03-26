package edu.TimeTracker.Java_external.persistence.DAO;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import edu.TimeTracker.Java_external.persistence.entity.Track;
import edu.TimeTracker.Java_external.persistence.entity.User;
import edu.TimeTracker.Java_external.persistence.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDao implements GenericDao<Track>, UserPermissionDao<Track> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void create(Track track) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLTrack.CREATE.getQUERY())) {
            statementFiller(track, connection, preparedStatement);
            LOGGER.info("Track with id " + track.getTrackID() + " was successful create");
        } catch (SQLException | NullPointerException e) {
            LOGGER.error("Track wasn't create. This is stack trace: "+e.getStackTrace());
        }
    }

    @Override
    public Track getById(int key) {
        Track track;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLTrack.SELECT_BY_ID.QUERY)){
                statement.setInt(1,key);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next())return null;
            track = getTrack(resultSet);

        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            track=null;
        }
        return track;
    }

    @Override
    public Track getByName(String login) {
        return null;
    }

    @Override
    public void update(Track track, int id) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLTrack.UPDATE.getQUERY())){
            statement.setInt(7, id);
            statementFiller(track, connection, statement);
            LOGGER.info("Track with id " + id + " was successful update");
        } catch (SQLException | NullPointerException e) {
            LOGGER.error("Track wasn't update. This is stack trace: "+e.getStackTrace());
        }
    }

    private void statementFiller(Track track, Connection connection, PreparedStatement statement) throws SQLException {
        statement.setInt(1,track.getTrackID());
        if(!new Factory().getActivityDao().getById(track.getActivity().getActivityId()).equals(track.getActivity())) throw new SQLException();
        statement.setInt(2,track.getActivity().getActivityId());
        statement.setBoolean(3, track.isActive());
        statement.setBoolean(4,track.isCompleted());
        statement.setTime(5,track.getElapsedTime());
        if(!new Factory().getUserDao().getById(track.getUser().getUserId()).equals(track.getUser())) throw new SQLException();
        statement.setInt(6,track.getUser().getUserId());
        statement.executeUpdate();
        connection.commit();
    }

    @Override
    public void delete(int id) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLTrack.DELETE.getQUERY())){
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Track with id " + id + " was successful delete");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    //not necessarily for admin
    @Override
    public List<Track> getAllWithPagination(int offset, int recordPerPage) {
        return null;
    }

    @Override
    public int getCountObjects() {
        return 0;
    }



    @Override
    public List<Track> getAllWithPagination(int userID, int offset, int records) {
        List<Track> list;
        Track track;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLTrack.SELECT_ALL.getQUERY())){
            statement.setInt(1,userID);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next())return null;
                list= new ArrayList<>();
                do {
                    track = getTrack(resultSet);
                    list.add(track);
            }while (resultSet.next());

        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            list=null;
        }
        return list;
    }

    @Override
    public int getRecords(int UserId) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM track WHERE user=?")){
            statement.setInt(1,UserId);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next())return 0;
            return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e);
            return 0;
        }
    }


    private Track getTrack(ResultSet resultSet) throws SQLException {
        Track track;
        track = new Track();
        track.setTrackID(resultSet.getInt("track_id"));
        track.setActivity(
                new Factory().getActivityDao().getById(resultSet.getInt("activity")));
        track.setActive(resultSet.getBoolean("isActive"));
        track.setCompleted(resultSet.getBoolean("isComplete"));
        track.setElapsedTime(resultSet.getTime("elapsedTime"));
        track.setUser(
                new Factory().getUserDao().getById(resultSet.getInt("user")));
        return track;
    }


    enum SQLTrack{
        SELECT_BY_ID("SELECT * FROM track WHERE track_id=?"),
        SELECT_ALL("SELECT * FROM track WHERE user=?"),
        SELECT_ALL_USERs("SELECT * FROM track WHERE user=? LIMIT ?,?"),
        CREATE("INSERT INTO track (track_id, activity, isActive, isComplete, elapsedTime, user) VALUES(?,?,?,?,?,?)"),
        UPDATE("UPDATE track SET track_id=?, activity=?, isActive=?, isComplete=?, elapsedTime=?, user=? WHERE track_id=?"),
        DELETE("DELETE FROM track WHERE track_id=?");


        private String QUERY;

        SQLTrack(String query) {
            this.QUERY = query;
        }

        public String getQUERY() {
            return QUERY;
        }
    }
}
