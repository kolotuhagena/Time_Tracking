package edu.time_tracker.java_external.persistence.dao;

import edu.time_tracker.java_external.persistence.dao.Factory.Factory;
import edu.time_tracker.java_external.persistence.entity.Request;
import edu.time_tracker.java_external.persistence.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao implements GenericDao<Request>, UserPermissionDao<Request> {
    private final Logger LOGGER = Logger.getLogger(RequestDao.class);

    @Override
    public void create(Request request) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.CREATE.getQUERY())) {
            statementFiller(request, connection, statement);
            LOGGER.info("Request with id " + request.getRequestId() + " was successful create");
        } catch (SQLException e) {
            LOGGER.error("Request with id " + request.getRequestId() + " wasn't create");
        }
    }

    @Override
    public Request getById(int id) {
        Request request;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.SELECT_BY_ID.getQUERY())) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            request = getRequest(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            request = null;
        }
        return request;
    }

    @Override
    public Request getByName(String login) {
        return null;
    }

    @Override
    public void update(Request request, int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.UPDATE.getQUERY())) {
            statement.setInt(5, id);
            statementFiller(request, connection, statement);
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    private void statementFiller(Request request, Connection connection, PreparedStatement statement) throws SQLException {
        statement.setInt(1, request.getRequestId());
        statement.setString(2, request.getType().getName());
        statement.setInt(3, request.getActivity().getActivityId());
        statement.setInt(4, request.getUser().getUserId());
        statement.executeUpdate();
        connection.commit();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.DELETE.getQUERY())) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("Request with id " + id + " was successful delete");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public List<Request> getAllWithPagination(int offset, int records) {
        List<Request> list;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.SELECT_ALL.getQUERY())) {
            statement.setInt(1, offset);
            statement.setInt(2, records);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            list = new ArrayList<>();
            Request request;
            do {
                request = getRequest(resultSet);
                list.add(request);
            } while (resultSet.next());
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            list = null;
        }
        return list;
    }

    @Override
    public int getCountObjects() {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLRequest.GET_RECORDS.getQUERY());
            if (!resultSet.next()) return 0;
            return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e);
            return 0;
        }
    }


    private Request getRequest(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setRequestId(resultSet.getInt(1));
        request.setType(resultSet.getString(2));
        request.setActivity(new Factory().getActivityDao().getById(resultSet.getInt(3)));
        request.setUser(new Factory().getUserDao().getById(resultSet.getInt(4)));
        return request;
    }

    @Override
    public List<Request> getAllWithPagination(int userId, int offset, int recordPerPage) {
        List<Request> list;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLRequest.SELECT_ALL_USERs.getQUERY())) {
            statement.setInt(1, userId);
            statement.setInt(2, offset);
            statement.setInt(3, recordPerPage);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            list = new ArrayList<>();
            Request request;
            do {
                request = getRequest(resultSet);
                list.add(request);
            } while (resultSet.next());
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            list = null;
        }
        return list;
    }

    @Override
    public int getRecords(int UserId) {
        return 0;
    }

    enum SQLRequest {
        SELECT_BY_ID("SELECT * FROM request WHERE request_id=?"),
        SELECT_ALL("SELECT * FROM request LIMIT ?,?"),
        SELECT_ALL_USERs("SELECT * FROM request WHERE user=? LIMIT ?,?"),
        GET_RECORDS("SELECT COUNT(*) FROM request"),
        CREATE("INSERT INTO request (request_id, type, activity, user) VALUES(?,?,?,?)"),
        UPDATE("UPDATE request SET request_id=?, type=?, activity=?, user=? WHERE request_id=?"),
        DELETE("DELETE FROM request WHERE request_id=?");


        private String QUERY;

        SQLRequest(String query) {
            this.QUERY = query;
        }

        public String getQUERY() {
            return QUERY;
        }

    }
}
