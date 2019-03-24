package edu.TimeTracker.Java_external.persistence.DAO;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import edu.TimeTracker.Java_external.persistence.entity.Track;
import edu.TimeTracker.Java_external.persistence.util.SimpleConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDao implements GenericDao<Track> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void create(Track track) {
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
        try(Connection connection = SimpleConnection.getInstance().getConnection();
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
        try(Connection connection = SimpleConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLTrack.UPDATE.getQUERY())){
            statement.setInt(6, id);
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
        statement.executeUpdate();
        connection.commit();
    }

    @Override
    public void delete(int id) {
        try(Connection connection = SimpleConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLTrack.DELETE.getQUERY())){
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Track with id " + id + " was successful delete");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public List<Track> getAll() {
        List<Track> list=null;
        Track track;
        try(Connection connection = SimpleConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLTrack.SELECT_ALL.QUERY)){
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

    private Track getTrack(ResultSet resultSet) throws SQLException {
        Track track;
        track = new Track();
        track.setTrackID(resultSet.getInt("track_id"));
        track.setActivity(
                new Factory().getActivityDao().getById(resultSet.getInt("activity")));
        track.setActive(resultSet.getBoolean("isActive"));
        track.setCompleted(resultSet.getBoolean("isComplete"));
        track.setElapsedTime(resultSet.getTime("elapsedTime"));
        return track;
    }


    enum SQLTrack{
        SELECT_BY_ID("SELECT * FROM track WHERE track_id=?"),
        SELECT_ALL("SELECT * FROM track"),
        CREATE("INSERT INTO track (track_id, activity, isActive, isComplete, elapsedTime) VALUES(?,?,?,?,?)"),
        UPDATE("UPDATE track SET track_id=?, activity=?, isActive=?, isComplete=?, elapsedTime=? WHERE track_id=?"),
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
