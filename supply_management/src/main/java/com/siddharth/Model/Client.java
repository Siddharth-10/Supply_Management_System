package com.siddharth.Model;

import java.sql.Date;


public class Client {
    
    private int clientID;
    private String clientName;
    private Date clientDateOfBirth;
    private String clientPhoneNumber;
    private float clientRating;
    private String clientAddress;

    public Client(){

    }


    public Client(int clientID, String clientName, Date clientDateOfBirth, String clientPhoneNumber, float clientRating, String clientAddress) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientDateOfBirth = clientDateOfBirth;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientRating = clientRating;
        this.clientAddress = clientAddress;
    }

    public void setId(int clientID) {
        this.clientID = clientID;
    }

    public int getId() {
        return this.clientID;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getName() {
        return this.clientName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.clientDateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return this.clientDateOfBirth;
    }

    public void setContactInfo(String contactInfo) {
        this.clientPhoneNumber = contactInfo;
    }

    public String getContactInfo() {
        return this.clientPhoneNumber;
    }

    public void setRating(float rating) {
        this.clientRating = rating;
    }

    public float getRating() {
        return clientRating;
    }

    public void setAddress(String dealerName){
        this.clientAddress = dealerName;
    }

    public String getAddress(){
        return clientAddress;
    }
}