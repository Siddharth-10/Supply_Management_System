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
import com.siddharth.DAO.MaterialDAO;
import com.siddharth.Model.Material;


@Path("/materials")
public class MaterialRest {

    private static MaterialDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(MaterialDAO.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Material> showMaterialList() {

        List<Material> material = dao().show();
        return material;
    }

    @GET
    @Path("/checkmaterialID/{materialID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static int checkMaterialID(@PathParam("materialID") int materialID) {
        return dao().find(materialID);
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void insertMaterial(Material material) {

        dao().insert(material);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void updateMaterial(Material material) {

        dao().update(material);
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void deleteMaterial(@PathParam("id") int materialID) {

        dao().delete(materialID);
    }

    @GET
    @Path("/showmateriallist/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Material> showMyMaterialList(@PathParam("id") int dealerID){

        return dao().showMyMaterials(dealerID);
    }

    @GET
    @Path("/material/{materialID}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Material showMaterial(@PathParam("materialID") int materialID){
        
        return dao().findMaterial(materialID);
    }
    
}