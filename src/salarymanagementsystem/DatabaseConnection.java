package salarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {

        Connection connection = null;
        String database = "jdbc:sqlite:database.db";
        if (connection == null) {
            try {

                connection = DriverManager.getConnection(database);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            connection.close();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
       
            getConnection();
        
    }
}
