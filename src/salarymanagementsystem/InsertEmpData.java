
package salarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmpData extends DatabaseHendler {

    private String position;
    private String name;
    private String dateOfBirth;
    private String joiningDate;

    Connection connection;
    PreparedStatement statement;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public void insertData() {
        String insertsql = "INSERT into empinfo( name, position, dob, jd) VALUES(?,?,?,?)";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(insertsql);

            statement.setString(1, getName());
            statement.setString(2, getPosition());
            statement.setString(3, getDateOfBirth());
            statement.setString(4, getJoiningDate());

            statement.executeUpdate();
            System.out.println("Data Inserted!");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }

    }
}
