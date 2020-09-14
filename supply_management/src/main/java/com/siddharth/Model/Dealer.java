package com.siddharth.Model;

public class Dealer {

    private int dealerID;
    private String dealerName;
    private String dealerAddress;
    private String dealerPhoneNumber;
    private String dealerEmail;
    private float dealerRating;

    public Dealer(){
        
    }

    public Dealer(int dealerID,String dealerName,String dealerAddress, String dealerPhoneNumber, String dealerEmail,float rating){
        this.dealerID = dealerID;
        this.dealerName = dealerName;
        this.dealerAddress = dealerAddress;
        this.dealerPhoneNumber = dealerPhoneNumber;
        this.dealerEmail = dealerEmail;
        this.dealerRating = rating;
    }

    public void setDealerID(int dealerID){
        this.dealerID = dealerID;
    }

    public int getDealerID(){
        return dealerID;
    }

    public void setDealerPhoneNumber(String dealerPhoneNumber){
        this.dealerPhoneNumber = dealerPhoneNumber;
    }

    public String getDealerPhoneNumber(){
        return dealerPhoneNumber;
    }

    public void setDealerName(String dealerName){
        this.dealerName = dealerName;
    }

    public String getDealerName(){
        return dealerName;
    }

    public void setDealerAddress(String dealerAddress){
        this.dealerAddress = dealerAddress;
    }

    public String getDealerAddress(){
        return dealerAddress;
    }

    public void setDealerEmail(String dealerEmail){
        this.dealerEmail = dealerEmail;
    }

    public String getDealerEmail(){
        return dealerEmail;
    }

    public void setDealerRating(float rating) {
        this.dealerRating = rating;
    }

    public float getDealerRating() {
        return dealerRating;
    }
    
}