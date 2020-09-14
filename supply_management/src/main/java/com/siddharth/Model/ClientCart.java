package com.siddharth.Model;

public class ClientCart {

    private int clientID;
    private int materialID;
    private String materialName;
    private int dealerID;
    private float materialPrice;
    private int materialQuantity;
    private String materialQuality;

    public ClientCart(){

    }

    public ClientCart(int clientID, int materialID, String materialName, int dealerID, float materialPrice,int materialQuantity,String materialQuality){
        this.clientID = clientID;
        this.materialID = materialID;
        this.materialName = materialName;
        this.dealerID = dealerID;
        this.materialPrice = materialPrice;
        this.materialQuantity = materialQuantity;
        this.materialQuality = materialQuality;
    }

    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public int getClientID(){
        return clientID;
    }

    public void setMaterialID(int materialID){
        this.materialID = materialID;
    }

    public int getMaterialID(){
        return materialID;
    }

    public void setMaterialName(String materialName){
        this.materialName = materialName;
    }

    public String getMaterialName(){
        return materialName;
    }

    public void setDealerID(int dealerID){
        this.dealerID = dealerID;
    }

    public int getDealerID(){
        return dealerID;
    }

    public void setMaterialPrice(float materialPrice){
        this.materialPrice = materialPrice;
    }

    public float getMaterialPrice(){
        return materialPrice;
    }

    public void setMaterialQuantity(int materialQuantity){
        this.materialQuantity = materialQuantity;
    }

    public int getMaterialQuantity(){
        return materialQuantity;
    }

    public void setMaterialQuality(String materialQuality){
        this.materialQuality = materialQuality;
    }

    public String getMaterialQuality(){
        return materialQuality;
    }
    
}