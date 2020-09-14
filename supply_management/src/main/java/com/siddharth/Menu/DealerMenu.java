package com.siddharth.Menu;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.siddharth.Factory.ClientCartFactory;
import com.siddharth.Factory.MaterialFactory;
import com.siddharth.Factory.OfferFactory;
import com.siddharth.Model.ClientCart;
import com.siddharth.Model.Material;
import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

public class DealerMenu {

    private Scanner s = new Scanner(System.in);
    private int dealerID;

    public DealerMenu(int dealerID) {

        // FUTURE FEATURE - update material
        // FUTURE FEATURE - add options to see and update our details
        // change choice to int variable to add more than 9 choices

        this.dealerID = dealerID;
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("DEALER MENU");
            System.out.println("----------------------------------");
            System.out.println("Choose one of the options");
            System.out.println("1) View all materials");
            System.out.println("2) View your material");
            System.out.println("3) Add material");
            System.out.println("4) Delete material");
            System.out.println("5) View Negotiation Offers");
            System.out.println("6) Exit");
            char choice = s.next().charAt(0);

            switch (choice) {
                case '1':
                    viewAllMaterial();
                    break;
                case '2':
                    viewMyMaterial();
                    break;
                case '3':
                    addMaterial();
                    break;
                case '4':
                    deleteMaterial();
                    break;
                case '5':
                    viewOffers();
                    break;
                case '6':
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try Again.");
            }
        }

    }

    void viewAllMaterial() {

        List<Material> materials = MaterialFactory.showMaterialList();

        System.out.println("ALL MATERIAL LIST");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|\n";
        System.out.format(format, "ID", "NAME", "DEALER_ID", "PRICE", "QUANTITY", "QUALITY");

        for (Material material : materials) {
            System.out.format(format, material.getMaterialID(), material.getMaterialName(), material.getDealerID(),
                    material.getMaterialPrice(), material.getMaterialQuantity(), material.getMaterialQuality());
        }

    }

    void viewMyMaterial() {

        List<Material> materials = MaterialFactory.showMyMaterialList(dealerID);

        System.out.println("MY MATERIAL LIST");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|\n";
        System.out.format(format, "ID", "NAME", "DEALER_ID", "PRICE", "QUANTITY", "QUALITY");

        for (Material material : materials) {
            System.out.format(format, material.getMaterialID(), material.getMaterialName(), material.getDealerID(),
                    material.getMaterialPrice(), material.getMaterialQuantity(), material.getMaterialQuality());
        }

    }

    void addMaterial() {

        // can throw exceptions by enter wrong input type

        System.out.println("ADDING MATERIAL");

        Material material = new Material();
        Random random = new Random();

        material.setDealerID(dealerID);

        int materialID;
        while (true) {
            materialID = random.nextInt(100) + 1;
            if (MaterialFactory.checkMaterialID(materialID) != 1) {
                material.setMaterialID(materialID);
                break;
            }
        }

        System.out.println("Enter new material name");
        material.setMaterialName(s.next());

        System.out.println("Enter material price");
        material.setMaterialPrice(s.nextFloat());

        System.out.println("Enter material quantity");
        material.setMaterialQuantity(s.nextInt());

        System.out.println("Enter material Quality");
        material.setMaterialQuality(s.next());

        MaterialFactory.insertMaterial(material);
        System.out.println("MATERIAL ADDED");

    }

    void deleteMaterial() {

        // EXPLOIT- can delete any material even the ones not owned by the dealer
        // Can throw exceptions on wrong input type

        System.out.println("DELETING MATERIAL");

        System.out.println("Enter material ID");
        int materialID = s.nextInt();

        MaterialFactory.deleteMaterial(materialID);
        System.out.println("MATERIAL DELETED");

    }

    void viewOffers() {

        List<Offer> offers = OfferFactory.showOffersDealer(dealerID);

        System.out.println("ALL OFFERS");
        String format = "|%1$-20s|%2$-20s|%3$-20s|\n";
        System.out.format(format, "CLIENT_ID", "MATERIAL_ID", "PRICE", "OFFER_STATUS");

        for(Offer offer:offers){
            System.out.format(format, offer.getClientID(),offer.getMaterialID(),offer.getPrice(),offer.getOfferStatus());
        }

        System.out.println("Choose one of the following options");
        System.out.println("1) Accept/Reject Offer");
        System.out.println("Press any other key to exit");
        int choice = s.nextInt();
        if(choice == 1){
            System.out.println("Enter Client ID");
            int clientID = s.nextInt();
            System.out.println("Enter Material ID");
            int materialID = s.nextInt();
            System.out.println("Enetr Price");
            int price = s.nextInt();
            while(true){
                System.out.println("Do you want to Accept or Reject?");
                String status = s.next();
                if(status.equals("Accept")){
                    OfferStatus offerStatus = OfferStatus.ACCEPT;
                    OfferFactory.updateStatus(clientID, materialID, dealerID, price, offerStatus);
                    ClientCart clientCart = ClientCartFactory.showMaterial(materialID, clientID);
                    clientCart.setMaterialPrice(price);
                    ClientCartFactory.updatePrice(price, clientID, dealerID, materialID);
                    return;
                }
                else if(status.equals("Reject")){
                    OfferStatus offerStatus = OfferStatus.REJECT;
                    OfferFactory.updateStatus(clientID, materialID, dealerID, price, offerStatus);
                    return;
                }
                else{
                    System.out.println("Invalid option");
                }
            }
        }
    }

}