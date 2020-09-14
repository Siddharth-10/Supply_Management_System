package com.siddharth.Menu;

import java.util.List;
import java.util.Scanner;

import com.siddharth.Factory.ClientCartFactory;
import com.siddharth.Factory.MaterialFactory;
import com.siddharth.Factory.OfferFactory;
import com.siddharth.Model.ClientCart;
import com.siddharth.Model.Material;
import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

public class ClientMenu {

    private Scanner s = new Scanner(System.in);
    private int clientID;

    public ClientMenu(int clientID) {

        this.clientID = clientID;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("CLIENT MENU");
            System.out.println("---------------------------------");
            System.out.println("1) View All Materials");
            System.out.println("2) Add Material to Cart");
            System.out.println("3) View my Cart");
            System.out.println("4) Negotiate an item from Cart");
            System.out.println("5) Exit");
            int choice = s.nextInt();

            switch(choice){
                case 1:
                    viewAllMaterial();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    negotiate();
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }

    void viewAllMaterial(){

        List<Material> materials = MaterialFactory.showMaterialList();

        System.out.println("ALL MATERIAL LIST");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|\n";
        System.out.format(format, "ID", "NAME", "DEALER_ID", "PRICE", "QUANTITY", "QUALITY");

        for(Material material: materials){
            System.out.format(format, material.getMaterialID(), material.getMaterialName(),material.getDealerID(),material.getMaterialPrice(),material.getMaterialQuantity(),material.getMaterialQuality());
        }

    }

    void addToCart(){

        ClientCart clientCart = new ClientCart();

        System.out.println("Enter Material ID you want to add");
        int materialID = s.nextInt();
        if (MaterialFactory.checkMaterialID(materialID) == 1){
            Material material = MaterialFactory.showMaterial(materialID);
            clientCart.setClientID(clientID);
            clientCart.setMaterialID(materialID);
            clientCart.setDealerID(material.getDealerID());
            clientCart.setMaterialName(material.getMaterialName());
            clientCart.setMaterialPrice(material.getMaterialPrice());
            clientCart.setMaterialQuality(material.getMaterialQuality());
            clientCart.setMaterialQuantity(1);

            int materialQuantity = material.getMaterialQuantity();
            material.setMaterialQuantity(materialQuantity - 1);
            MaterialFactory.updateMaterial(material);

            ClientCartFactory.addToCart(clientCart);

            System.out.println("ADDED TO CART");
        }
        else{
            System.out.println("Invalid material ID");
        }

    }

    void viewCart(){

        List<ClientCart> clientCarts = ClientCartFactory.showMyCart(clientID);

        System.out.println("CLIENT CART");
        String format = "|%1$-20s|%2$-20s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|%7$-20s|\n";
        System.out.format(format, "CLIENT_ID", "MATERIAL_ID", "MATERIAL_NAME", "DEALER_ID", "PRICE", "QUANTITY", "QUALITY");

        for(ClientCart clientCart : clientCarts){
            System.out.format(format,clientCart.getClientID(),clientCart.getMaterialID(), clientCart.getMaterialName(), clientCart.getDealerID(), clientCart.getMaterialPrice(),clientCart.getMaterialQuantity(), clientCart.getMaterialQuality());
        }
        
    }

    void negotiate(){

        System.out.println("Enter material ID in Cart");
        int materialID = s.nextInt();

        if(ClientCartFactory.findMaterial(materialID, clientID) == 1){
            
            System.out.println("Negotiation Page for material ID = "+ materialID);
            ClientCart clientCart = ClientCartFactory.showMaterial(materialID, clientID);
            System.out.println("Material Details");
            System.out.println("Material ID = " +  clientCart.getMaterialID());
            System.out.println("Client ID =" + clientCart.getClientID());
            System.out.println("Dealer ID =" + clientCart.getDealerID());
            System.out.println("Material Name = "+ clientCart.getMaterialName());
            System.out.println("Price =" + clientCart.getMaterialPrice());
            System.out.println("Quality =" + clientCart.getMaterialQuality());
            System.out.println();
            System.out.println("Choose one of the options");
            System.out.println("1) Make Offer");
            System.out.println("2) See Previous Offers");
            System.out.println("3) Press any other key to exit");
            int choice = s.nextInt();
            if(choice == 1){

                System.out.println("Enter Offer price");
                int price = s.nextInt();
                Offer offer = new Offer(clientID,clientCart.getDealerID(),materialID,price,OfferStatus.PENDING);

                OfferFactory.insertOffer(offer);

            }
            else if(choice == 2){

                List<Offer> offers = OfferFactory.showOfferClient(clientID, materialID);

                System.out.println("OFFER HISTORY");
                String format = "|%1$-20s|%2$-20s|%3$-20s|\n";
                System.out.format(format, "MATERIAL_ID", "PRICE", "OFFER_STATUS");

                for(Offer offer: offers){
                    System.out.format(format, offer.getMaterialID(),offer.getPrice(),offer.getOfferStatus());
                }
            }
        }
    }

}