package com.siddharth.Rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.OfferDAO;
import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

@Path("/offer")
public class OfferRest {
    
    private static OfferDAO dao(){
        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(OfferDAO.class);
    }

    @GET
    @Path("/showofferdealer/{dealerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Offer> showOffersDealer(@PathParam("dealerID") int dealerID){
        List<Offer> offer = dao().showDealer(dealerID);
        return offer;
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void insertOffer(Offer offer){
        dao().insert(offer);
    }

    @GET
    @Path("/showofferclient/{clientID}/{materialID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Offer> showOfferClient(@PathParam("clientID") int clientID,@PathParam("materialID") int materialID){
        List<Offer> offer =  dao().showClient(clientID, materialID);
        return offer;
    }
    
    @PUT
    @Path("/update/{clientID}/{materialID}/{dealerID}/{price}/{status}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void updateStatus(@PathParam("clientID") int clientID,@PathParam("materialID") int materialID,@PathParam("dealerID") int dealerID,@PathParam("price") int price,@PathParam("status") OfferStatus status){
        dao().updateStatus(clientID, dealerID, materialID, price,status);
    }
    
}