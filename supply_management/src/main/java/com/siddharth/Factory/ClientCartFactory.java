package com.siddharth.Factory;

import java.util.List;

import com.siddharth.DAO.ClientCartDAO;
import com.siddharth.DAO.DbConnection;
import com.siddharth.Model.ClientCart;

public class ClientCartFactory {

    private static ClientCartDAO dao(){

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(ClientCartDAO.class);
    }

    public static List<ClientCart> showMyCart(int clientID){
        
        return dao().showList(clientID);
    }

    public static void addToCart(ClientCart clientCart){
        dao().insert(clientCart);
    }

    public static int findMaterial(int materialID, int clientID){
        return dao().find(materialID, clientID);
    }

    public static ClientCart showMaterial(int materialID,int clientID){
        return dao().showMaterial(materialID, clientID);
    }

    public static void updatePrice(int price, int clientID,int dealerID, int materialID){
        dao().updatePrice(price, clientID, dealerID, materialID);
    }
    
}