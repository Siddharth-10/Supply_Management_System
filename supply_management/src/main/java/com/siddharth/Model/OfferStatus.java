package com.siddharth.Model;

public enum OfferStatus {

    ACCEPT("ACCEPT"),
    REJECT("REJECT"),
    PENDING("PENDING");

    private String offerStatusName;

    private OfferStatus(String offerStatusName){
        this.offerStatusName = offerStatusName;
    }
    
}