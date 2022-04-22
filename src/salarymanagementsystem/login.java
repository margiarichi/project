
package salarymanagementsystem;

public class login {

    private String user_name;
    private String password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void LoginMain() {

        if (getUser_name().equals("admin") && getPassword().equals("123")) {

            MainMenu mainMenu = new MainMenu();
            mainMenu.operationSet();
        } else {
            System.out.println("Wrong password or username");
        }

    }

}
