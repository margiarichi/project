
package salarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteEmpData extends DatabaseHendler {

    private int id;

    Connection connection;
    PreparedStatement statement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void deleteData() {

        String searchSql = "DELETE FROM empinfo WHERE id =" + getId() + "";

        try {

            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(searchSql);
            statement.executeUpdate();
            System.out.println("Employee Data Deleted Successfully!");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }
    }

}
