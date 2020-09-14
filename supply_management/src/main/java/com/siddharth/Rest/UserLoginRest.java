package com.siddharth.Rest;

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
import com.siddharth.DAO.UserLoginDAO;
import com.siddharth.Model.UserLogin;

@Path("/userlogin")
public class UserLoginRest {

    private static UserLoginDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(UserLoginDAO.class);
    }

    @GET
    @Path("/checkUsername/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public static int checkUsername(@PathParam("username") String userName) {

        return dao().findUsername(userName);
    }

    @GET
    @Path("/getuserlogin/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public static UserLogin getUserLogin(@PathParam("username") String username) {
        return dao().getData(username);
    }

    @GET
    @Path("/getpassword/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public static String getPassword(@PathParam("username") String username) {
        return dao().getPassword(username);
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void insertUserLogin(UserLogin userLogin){
        String userType =  userLogin.getUserType().name();
        dao().insert(userLogin,userType);

    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void updateUserLogin(UserLogin userLogin){
        dao().update(userLogin);
    }

    @DELETE
    @Path("/delete/{userID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void deleteUserLogin(int userID){
        dao().delete(userID);
    }

    @GET
    @Path("/checkuserID/{userID}")
    public static int checkUserID(@PathParam("userID") int userID){
        return dao().findUserID(userID);
    }
    
}