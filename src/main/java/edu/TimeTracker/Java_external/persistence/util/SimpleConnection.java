package edu.TimeTracker.Java_external.persistence.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SimpleConnection {
  private SimpleConnection() {

  }

  private static SimpleConnection instance = null;
  private final Logger LOGGER = Logger.getLogger(this.getClass());
  public static SimpleConnection getInstance() {
    if (instance == null) {
      instance = new SimpleConnection();
    }
    return instance;
  }

  public Connection getConnection() {
    Connection connection = null;
    LOGGER.setLevel(Level.ERROR);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    try {
      Class.forName(resourceBundle.getString("driver"));
      connection = DriverManager.getConnection(resourceBundle.getString("db_url"),
              resourceBundle.getString("user"),
              resourceBundle.getString("password"));
      LOGGER.info("Successful connection");
      connection.setAutoCommit(false);
    } catch (ClassNotFoundException | SQLException e) {
      LOGGER.error("Connection is failed");
    }
    return connection;
  }
}
