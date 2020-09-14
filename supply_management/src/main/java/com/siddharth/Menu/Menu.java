package com.siddharth.Menu;

import java.util.Scanner;

import com.siddharth.Factory.UserLoginFactory;
import com.siddharth.Model.UserLogin;
import com.siddharth.Model.UserType;

public class Menu {

    public Menu() {

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------");
            System.out.println("SUPPLY CHAIN MANAGEMENT SYSTEM");
            System.out.println("------------------------------");
            System.out.println("--LOGIN--");
            System.out.println("Enter Username:");
            String username = s.next();
            if (UserLoginFactory.checkUsername(username) == 1) {
                while (true) {
                    System.out.println("Enter Password:");
                    String password = s.next();
                    System.out.println(password);
                    if (password.equals(UserLoginFactory.getPassword(username))) {
                        System.out.println("Login Successful");
                        UserLogin userLogin = UserLoginFactory.getUserLogin(username);
                        UserType usertype = userLogin.getUserType();
                        if (usertype == UserType.ADMIN) {
                            new AdminMenu();
                        } else if (usertype == UserType.CLIENT) {
                            new ClientMenu(userLogin.getUserID());
                        } else {
                            new DealerMenu(userLogin.getUserID());
                        }
                        break;

                    } else {
                        System.out.println("Password does not match with the username");
                        System.out.println("Enter password again? Press y for yes and any other key for exit");
                        int choice = s.next().charAt(0);
                        if (choice == 'Y' || choice == 'y') {
                            continue;
                        } else {
                            System.exit(0);
                        }
                    }
                }
            } else {
                System.out.println("Username Does not exist in our Database");
                System.out.println("Try Again ? Press y for yes and any other key for exit.");
                int choice = s.next().charAt(0);
                if (choice == 'Y' || choice == 'y') {
                    continue;
                } else {
                    break;
                }
            }
        }
        s.close();
    }

}