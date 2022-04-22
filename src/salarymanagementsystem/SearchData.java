/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarymanagementsystem;

import java.sql.*;

public class SearchData extends DatabaseHendler {

    private int id;

    Connection connection;
    PreparedStatement statement;
    ResultSet set;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void searchData() {

        int flag = 0;
        String searchSql = "SELECT empinfo.id, empinfo.name, empinfo.dob, empinfo.jd, salaryinfo.pname, salaryinfo.salary FROM empinfo INNER JOIN salaryinfo  ON empinfo.position = salaryinfo.position WHERE empinfo.id =" + getId() + "";

        try {

            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(searchSql);
            set = statement.executeQuery();

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
                    System.out.println("\tData Found!"
                            + "\n======================");
                    System.out.println("\nID: " + set.getInt("id")
                            + "\nName: " + set.getString("name")
                            + "\nPosition: " + set.getString("pname")
                            + "\nDate Of Birth: " + set.getString("dob")
                            + "\nJoining Date: " + set.getString("jd")
                            + "\nBasic Salary: " + salary
                            + "\nHouse Rent: " + houseRent
                            + "\nMedical Fee: " + medical
                            + "\nTiffin Fee: " + tiffin
                            + "\nNet Salary: " + netSalary
                            + "\nProvident Fund: " + fund
                            + "\nGross Salary: " + grossSalary
                            + "\n"
                    );

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
