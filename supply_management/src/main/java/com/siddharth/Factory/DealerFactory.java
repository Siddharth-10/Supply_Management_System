package com.siddharth.Factory;

import java.util.List;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.DealerDAO;
import com.siddharth.Model.Dealer;

public class DealerFactory {

    private static DealerDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(DealerDAO.class);
    }

    public static List<Dealer> showDealerList() {

        List<Dealer> dealer = dao().show();
        return dealer;

    }

    public static Dealer showDealer(int dealerID) {

        Dealer dealer = dao().find(dealerID);
        return dealer;
    }

    public static void insertDealer(Dealer dealer) {

        dao().insert(dealer);
    }

    public static void updateDealer(Dealer dealer) {

        dao().update(dealer);
    }

    public static void deleteDealer(int dealerID) {

        dao().delete(dealerID);
    }

}