
package salarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayData extends DatabaseHendler {

    Connection connection;
    PreparedStatement statement;
    ResultSet set;

    @Override
    public void displayData() {
        int flag = 0;
        String searchSql = "SELECT empinfo.id, empinfo.name, empinfo.dob, empinfo.jd, salaryinfo.pname, salaryinfo.salary FROM empinfo INNER JOIN salaryinfo  ON empinfo.position = salaryinfo.position";

        try {

            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(searchSql);
            set = statement.executeQuery();
            System.out.println("\nID "
                    + "\tName "
                    + "\t\t\tPosition "
                    + "\tDate Of Birth "
                    + "\tJoining Date "
                    + "\tBasic Salary "
                    + "\tHouse Rent "
                    + "\tMedical Fee "
                    + "\tTiffin Fee "
                    + "\tNet Salary "
                    + "\tProvident Fund "
                    + "\t\tGross Salary "
                    + "");

            while (set.next()) {
                flag = 1;
                if (set.getInt("id") != -1) {

                    double salary = Double.parseDouble(set.getString("salary"));
                    double houseRent = salary * 0.35;
                    double medical = 2000;
                    double tiffin = 200;
                    double fund = salary * 0.05;
                    double grossSalary = salary + houseRent + medical + tiffin;
                    double netSalary = (salary - fund) + houseRent + medical + tiffin;

                    System.out.println(set.getInt("id")
                            + "\t" + set.getString("name")
                            + "\t\t\t" + set.getString("pname")
                            + "\t\t" + set.getString("dob")
                            + "\t" + set.getString("jd")
                            + "\t" + salary
                            + "\t\t" + houseRent
                            + "\t\t" + medical
                            + "\t\t" + tiffin
                            + "\t\t" + netSalary
                            + "\t\t" + fund
                            + "\t\t\t" + grossSalary
                            + "");

                }
            }
            if (flag == 0) {
                System.out.println("Table is empty");
            }
            statement.close();
            set.close();
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
