package com.siddharth.Factory;

import java.util.List;

import com.siddharth.DAO.ClientDAO;
import com.siddharth.DAO.DbConnection;
import com.siddharth.Model.Client;

public class ClientFactory {

    private static ClientDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(ClientDAO.class);
    }

    public static List<Client> showClientList() {

        List<Client> client = dao().show();
        return client;
    }

    public static Client showClient(int clientID) {

        Client client = dao().find(clientID);
        return client;
    }

    public static void insertClient(Client client) {

        dao().insert(client);

    }

    public static void updateClient(Client client) {

        dao().update(client);
    }

    public static void deleteClient(int clientID) {

        dao().delete(clientID);
    }

}