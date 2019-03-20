package edu.TimeTracker.Java_external.entity.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
        private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
        private ConnectionPool() {
        }

        private static ConnectionPool instance = null;

        public static ConnectionPool getInstance() {
            if (instance == null) {
                instance = new ConnectionPool();
            }
            return instance;
        }

        public Connection getConnection() {
            //Get DataSource
            Context context;
            Connection connection = null;
            try {
                context = new InitialContext();
                DataSource dataSource = (DataSource) context.lookup("///");
                connection = dataSource.getConnection();
                //для транзакцій,щоб після запитів робити коміти
                connection.setAutoCommit(false);
            } catch (NamingException | SQLException e) {
                LOGGER.log(Level.ERROR,e.getCause());
            }
            return connection;
        }
}
