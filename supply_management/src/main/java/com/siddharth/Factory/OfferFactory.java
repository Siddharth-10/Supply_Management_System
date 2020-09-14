package com.siddharth.Factory;

import java.util.List;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.OfferDAO;
import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

public class OfferFactory {

    private static OfferDAO dao(){
        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(OfferDAO.class);
    }

    public static List<Offer> showOffersDealer(int dealerID){
        List<Offer> offer = dao().showDealer(dealerID);
        return offer;
    }

    public static void insertOffer(Offer offer){
        dao().insert(offer);
    }

    public static List<Offer> showOfferClient(int clientID,int materialID){
        List<Offer> offer =  dao().showClient(clientID, materialID);
        return offer;
    }
    
    public static void updateStatus(int clientID,int materialID, int dealerID, int price,OfferStatus status){
        dao().updateStatus(clientID, dealerID, materialID, price,status);
    }

}