package com.siddharth.Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.siddharth.Factory.ClientFactory;
import com.siddharth.Factory.DealerFactory;
import com.siddharth.Factory.UserLoginFactory;
import com.siddharth.Model.Client;
import com.siddharth.Model.Dealer;
import com.siddharth.Model.UserLogin;
import com.siddharth.Model.UserType;

public class AdminMenu {

    private Scanner s = new Scanner(System.in);

    public AdminMenu() {

        adminMenu();

    }

    public void adminMenu() {

        //FUTURE FEATURE - update feature for client and dealer
        //FUTURE FEATURE - add/delete admins
        //change choice to int variable to add more than 9 choices

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("ADMIN MENU");
            System.out.println("---------------------------------");
            System.out.println("Choose one of the options");
            System.out.println("1) Show  Clients");
            System.out.println("2) Add Client");
            System.out.println("3) Delete Client");
            System.out.println("4) Show Dealer");
            System.out.println("5) Add Dealer");
            System.out.println("6) Delete Dealer");
            System.out.println("7) Exit the program");
            char choice = s.next().charAt(0);

            switch (choice) {
                case '1':
                    showClient();
                    break;
                case '2':
                    addClient();
                    break;
                case '3':
                    deleteClient();
                    break;
                case '4':
                    showDealer();
                    break;
                case '5':
                    addDealer();
                    break;
                case '6':
                    deleteDealer();
                    break;
                case '7':
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try Again.");
            }

        }
    }

    void showClient() {

        List<Client> clients = ClientFactory.showClientList();

        System.out.println("CLIENT LIST");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|\n";
        System.out.format(format, "ID", "NAME", "DOB", "PHONE NO.", "RATING", "ADDRESS"); 

        for (Client client : clients) {

            System.out.format(format, client.getId(), client.getName(), client.getDateOfBirth(),
                    client.getContactInfo(), client.getRating(), client.getAddress());

        }

    }

    void addClient() {

        //can throw exception on input types

        System.out.println("ADDING CLIENT");

        Client client = new Client();
        client.setRating(5);

        client.setId(addUserLogin(UserType.CLIENT));

        System.out.println("Enter client name");
        client.setName(s.next());

        System.out.println("Enter client date-of-birth");
        System.out.println("Enter year");
        int year = s.nextInt();
        System.out.println("Enter month");
        int month = s.nextInt();
        System.out.println("Enter day");
        int day = s.nextInt();
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        client.setDateOfBirth(java.sql.Date.valueOf(dateOfBirth));

        System.out.println("Enter client phone number");
        client.setContactInfo(s.next());

        System.out.println("Enter client address");
        client.setAddress(s.next());

        ClientFactory.insertClient(client);
        System.out.println("CLIENT ADDED");

    }

    void deleteClient() {

        //can throw exception on input types

        System.out.println("DELETING CLIENT");

        System.out.println("Enter client ID");
        int userID = s.nextInt();
        UserLoginFactory.deleteUserLogin(userID);
        ClientFactory.deleteClient(userID);
        System.out.println("CLIENT DELETED");

    }

    void showDealer() {

        List<Dealer> dealers = DealerFactory.showDealerList();

        System.out.println("DEALER LIST");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|\n";
        System.out.format(format, "ID", "NAME", "ADDRESS", "PHONE NO.", "EMAIL", "ADDRESS");

        for (Dealer dealer : dealers) {

            System.out.format(format, dealer.getDealerID(), dealer.getDealerName(), dealer.getDealerAddress(),
                    dealer.getDealerPhoneNumber(), dealer.getDealerEmail(), dealer.getDealerAddress());

        }

    }

    void addDealer() {

        //can throw exception on input types

        System.out.println("ADDING DEALER");

        Dealer dealer = new Dealer();
        dealer.setDealerRating(5);

        dealer.setDealerID(addUserLogin(UserType.DEALER));

        System.out.println("Enter dealer name");
        dealer.setDealerName(s.next());

        System.out.println("Enter dealer address");
        dealer.setDealerAddress(s.next());

        System.out.println("Enter dealer phone number");
        dealer.setDealerPhoneNumber(s.next());

        System.out.println("Enter dealer Email");
        dealer.setDealerEmail(s.next());

        DealerFactory.insertDealer(dealer);
        System.out.println("DEALER ADDED");
    }

    void deleteDealer() {

        //can throw exception on input types

        System.out.println("DELETING DEALER");

        System.out.println("Enter client ID");
        int userID = s.nextInt();
        UserLoginFactory.deleteUserLogin(userID);
        DealerFactory.deleteDealer(userID);
        System.out.println("DEALER DELETED");

    }

    int addUserLogin(UserType usertype) {

        //can throw exception on input types

        UserLogin userLogin = new UserLogin();
        userLogin.setUserType(usertype);

        while (true) {

            System.out.println("Enter new username");
            String username = s.next();

            if (UserLoginFactory.checkUsername(username) != 1) {
                userLogin.setUserName(username);
                break;
            } else {
                System.out.println("Username already exists");
                System.out.println("Try Again");
            }
        }

        System.out.println("Enter new password");
        userLogin.setPassword(s.next());

        int clientID;

        while (true) {
            Random random = new Random();
            clientID = random.nextInt(100) + 1;
            if (UserLoginFactory.checkUserID(clientID) != 1) {
                userLogin.setUserID(clientID);
                UserLoginFactory.insertUserLogin(userLogin);
                break;
            }
        }

        return clientID;

    }

}