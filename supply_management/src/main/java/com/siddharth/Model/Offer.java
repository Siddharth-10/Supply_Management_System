package com.siddharth.Model;

public class Offer {

    int clientID;
    int dealerID;
    int materialID;
    int price;
    OfferStatus offerStatus;

    public Offer(){

    }

    public Offer(int clientID, int dealerID, int materialID, int price, OfferStatus offerStatus){
        this.clientID = clientID;
        this.dealerID = dealerID;
        this.materialID = materialID;
        this.price = price;
        this.offerStatus = offerStatus;
    }

    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public int getClientID(){
        return clientID;
    }

    public void setDealerID(int dealerID){
        this.dealerID = dealerID;
    }

    public int getDealerID(){
        return dealerID;
    }

    public void setMaterialID(int materialID){
        this.materialID = materialID;
    }

    public int getMaterialID(){
        return materialID;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setOfferStatus(OfferStatus offerStatus){
        this.offerStatus = offerStatus;
    }

    public OfferStatus getOfferStatus(){
        return offerStatus;
    }
    
}