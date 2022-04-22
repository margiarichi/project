
package salarymanagementsystem;

import java.util.Scanner;

public class SalaryManagementSystem {

//    Welcome Note
    static String welcome = "\tWelcome, Please Login"
            + "\n========================================";

    public static void login() {
        Scanner input = new Scanner(System.in);
        login log = new login();
        System.out.println("Enter Your Username");
        log.setUser_name(input.nextLine());
        System.out.println("Enter Password");
        log.setPassword(input.nextLine());
        log.LoginMain();
    }
//Getting User Input for login

    public static void main(String[] args) {

        System.out.println(welcome);
        login();
    }

}
