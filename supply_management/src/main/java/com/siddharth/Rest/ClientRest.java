package com.siddharth.Rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.siddharth.DAO.ClientDAO;
import com.siddharth.DAO.DbConnection;
import com.siddharth.Model.*;


@Path("/clients")
public class ClientRest {

    
    private static ClientDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(ClientDAO.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Client> showClientList() {

        List<Client> client = dao().show();
        return client;
    }

    @GET
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public static Client showClient(@PathParam("id") int clientID) {

        Client client = dao().find(clientID);
        return client;
    }

    @POST
    @Path("/insert")	// correctd here
    @Consumes(MediaType.APPLICATION_JSON) // corrected here
    public static Client insertClient(Client client) {

        dao().insert(client);
        return client;

    }

    @PUT //corrected here
    @Path("/update") //corrected here
    @Consumes(MediaType.APPLICATION_JSON) // corrected here
    public static Client updateClient(Client client) {

        dao().update(client);

        return client;
    }
    
    @DELETE
    @Path("/delete/{id}") 
    @Consumes(MediaType.APPLICATION_JSON) // corrected here
    public static void deleteClient(@PathParam("id") int clientID) {

        dao().delete(clientID);
    }

}
    
