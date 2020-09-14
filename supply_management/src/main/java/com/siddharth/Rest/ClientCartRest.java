package com.siddharth.Rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.siddharth.DAO.ClientCartDAO;
import com.siddharth.DAO.DbConnection;
import com.siddharth.Model.ClientCart;

@Path("/clientcart")
public class ClientCartRest {
    
    private static ClientCartDAO dao(){

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(ClientCartDAO.class);
    }

    @GET
    @Path("/showmycart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ClientCart> showMyCart(@PathParam("id") int clientID){
        return dao().showList(clientID);
    }

    @POST
    @Path("/insert/")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void addToCart(ClientCart clientCart){
        dao().insert(clientCart);
    }

    @GET
    @Path("/findmaterial/{materialID}/{clientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static int findMaterial(@PathParam("materialID") int materialID,@PathParam("clientID") int clientID){
        return dao().find(materialID, clientID);
    }

    @GET
    @Path("/showmaterial/{materialID}/{clientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static ClientCart showMaterial(@PathParam("materialID") int materialID,@PathParam("clientID") int clientID){
        return dao().showMaterial(materialID, clientID);
    }

    @PUT
    @Path("/update/{price}/{clientID}/{dealerID}/{materialID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void updatePrice(@PathParam("price") int price,@PathParam("clientID") int clientID,@PathParam("dealerID") int dealerID,@PathParam("materialID") int materialID){
        dao().updatePrice(price, clientID, dealerID, materialID);
    }
    
}