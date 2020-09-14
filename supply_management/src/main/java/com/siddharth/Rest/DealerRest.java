package com.siddharth.Rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.DealerDAO;
import com.siddharth.Model.Dealer;

@Path("/dealers")
public class DealerRest {
    
    private static DealerDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(DealerDAO.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Dealer> showDealerList() {

        List<Dealer> dealer = dao().show();
        return dealer;

    }

    @GET
    @Path("/dealer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Dealer showDealer(@PathParam("id") int dealerID) {

        Dealer dealer = dao().find(dealerID);
        return dealer;
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void insertDealer(Dealer dealer) {

        dao().insert(dealer);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void updateDealer(Dealer dealer) {

        dao().update(dealer);
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void deleteDealer(@PathParam("id") int dealerID) {

        dao().delete(dealerID);
    }

}