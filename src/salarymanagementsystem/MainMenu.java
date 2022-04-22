
package salarymanagementsystem;

import java.util.Scanner;

public class MainMenu {

    String options = "\nSelect an Option."
            + "\n1. Add Employee"
            + "\n2. Add Salary"
            + "\n3. View Salary"
            + "\n4. View SalarySheet"
            + "\n5. Delete Data"
            + "\n6. Exit"
            + "\n";
    Scanner input = new Scanner(System.in);

    public void operationSet() {
        System.out.println(options);
        int selection = input.nextInt();
        switch (selection) {
            case 1:
                firstOperation();
                break;
            case 2:
                secondOperation();
                break;
            case 3:
                thirdOperation();
                break;
            case 4:
                fourthOperation();
                break;
            case 5:
                sixthOperation();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private void deleteOperation() {

        String menu = "\nPlease select."
                + "\n1. Delete Employee"
                + "\n2. Main Menu"
                + "\n";

        System.out.println(menu);
        int selection = input.nextInt();
        switch (selection) {
            case 1:
                DeleteEmpData deleteEmpData = new DeleteEmpData();
                System.out.println("Please Enter Employee ID: ");
                deleteEmpData.setId(input.nextInt());
                deleteEmpData.deleteData();
                operationSet();
                break;
            case 2:
                operationSet();
                break;
            default:
                break;
        }

    }

    private void firstOperation() {

        System.out.println("\nInsert Employee Data"
                + "\n==============================");
        InsertEmpData insertEmpData = new InsertEmpData();
        System.out.println("Enter Employee Name: ");
        insertEmpData.setName(input.next());
        input.nextLine();
        System.out.println("Enter Position: ");
        insertEmpData.setPosition(input.next());
        System.out.println("Enter Date of Birth: ");
        insertEmpData.setDateOfBirth(input.next());
        System.out.println("Enter Joining Date: ");
        insertEmpData.setJoiningDate(input.next());
        insertEmpData.insertData();
        operationSet();

    }

    private void secondOperation() {

        System.out.println("\nInsert Salary Data"
                + "\n==============================");
        InsertSalaryData insertSalaryData = new InsertSalaryData();
        System.out.println("Enter Position ID: ");
        insertSalaryData.setPosition(input.next());
        System.out.println("Enter Position Name: ");
        insertSalaryData.setPname(input.next());
        System.out.println("Enter Salary: ");
        insertSalaryData.setSalary(input.next());
        insertSalaryData.insertData();
        operationSet();
    }

    private void thirdOperation() {
        System.out.println("\nView Salary"
                + "\n==============================");
        SearchData searchData = new SearchData();
        System.out.println("Enter Employee ID:");
        searchData.setId(input.nextInt());
        searchData.searchData();
        operationSet();
    }

    private void fourthOperation() {
        System.out.println("\nView Salary Sheet"
                + "\n==============================");
        DisplayData displayData = new DisplayData();
        displayData.displayData();
        operationSet();
    }

//    private void fifthOperation() {
//
//        System.out.println("\nView Salary List"
//                + "\n==============================");
//        DisplaySalaryData displaySalaryData = new DisplaySalaryData();
//        displaySalaryData.displayData();
//        operationSet();
//
//    }

    private void sixthOperation() {
        System.out.println("\nDelete Data"
                + "\n==============================");
        deleteOperation();
    }

}
