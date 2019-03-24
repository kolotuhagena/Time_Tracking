package edu.TimeTracker.Java_external.persistence.DAO;

import edu.TimeTracker.Java_external.persistence.entity.User;
import edu.TimeTracker.Java_external.persistence.util.ConnectionPool;
import edu.TimeTracker.Java_external.persistence.util.SimpleConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GenericDao<User> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void create(User user) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.CREATE.getQUERY())) {
            statementFiller(user, connection, statement);
            LOGGER.info("User " + user.getLogin() + " was created");
        } catch (SQLException e) {
            LOGGER.error("User with username " + user.getLogin() + " already exist");
        }
    }


    @Override
    public void update(User user, int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.getQUERY())) {
            statement.setInt(6, id);
            statementFiller(user, connection, statement);
            LOGGER.info("User " + user.getLogin() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.getQUERY())) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            LOGGER.info("User with id " + id + " was successful deleted.");
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    @Override
    public User getById(int key) {
        User user = new User();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.SELECT_BY_ID.getQUERY())) {
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            getUserFromDB(user, resultSet);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            user = null;
        }
        return user;
    }
    @Override
    public User getByName(String login) {
        User user = new User();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLUser.SELECT_BY_NAME.getQUERY())) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            getUserFromDB(user, resultSet);
        } catch (SQLException  | NullPointerException e) {
            LOGGER.error(e);
            user = null;
        }
        return user;
    }

    @Override
    public List getAll() {
        List<User> list = new ArrayList<>();
        User user;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLUser.SELECT_ALL.getQUERY());
            while (resultSet.next()) {
                user = new User();
                getUserFromDB(user, resultSet);
                list.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
        }

        return list;
    }

    private void getUserFromDB(User user, ResultSet resultSet) throws SQLException {
        user.setUserId(resultSet.getInt("user_id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getInt("password"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getString("role"));
    }

    private void statementFiller(User user, Connection connection, PreparedStatement statement) throws SQLException {
        statement.setInt(1, user.getUserId());
        statement.setString(2, user.getLogin());
        statement.setInt(3, user.getPassword());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getRole().getName());
        statement.executeUpdate();
        connection.commit();
    }

    enum SQLUser {
        SELECT_BY_ID("SELECT * FROM user WHERE user_id=?"),
        SELECT_ALL("SELECT * FROM user"),
        SELECT_BY_NAME("SELECT * FROM user where login=?"),
        CREATE("INSERT INTO user (user_id, login, password, email, role) VALUES(?,?,?,?,?)"),
        UPDATE("UPDATE user SET user_id=?, login=?, password=?, email=?, role=? WHERE user_id=?"),
        DELETE("DELETE FROM user WHERE user_id=?");


        private String QUERY;

        SQLUser(String query) {
            this.QUERY = query;
        }

        public String getQUERY() {
            return QUERY;
        }
    }
}
