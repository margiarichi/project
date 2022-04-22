
package salarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSalaryData extends DatabaseHendler {

    private int id;
    private String position;
    private String pname;
    private String salary;

    Connection connection;
    PreparedStatement statement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public void insertData() {
        String insertsql = "INSERT into salaryinfo(position, pname, salary) VALUES(?,?,?)";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(insertsql);

            statement.setString(1, getPosition());
            statement.setString(2, getPname());
            statement.setString(3, getSalary());
            
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
