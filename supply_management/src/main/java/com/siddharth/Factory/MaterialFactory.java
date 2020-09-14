package com.siddharth.Factory;

import java.util.List;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.MaterialDAO;
import com.siddharth.Model.Material;

public class MaterialFactory {

    private static MaterialDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(MaterialDAO.class);
    }

    public static List<Material> showMaterialList() {

        List<Material> material = dao().show();
        return material;
    }

    public static int checkMaterialID(int materialID) {

        return dao().find(materialID);
    }

    public static void insertMaterial(Material material) {

        dao().insert(material);
    }

    public static void updateMaterial(Material material) {

        dao().update(material);
    }

    public static void deleteMaterial(int materialID) {

        dao().delete(materialID);
    }

    public static List<Material> showMyMaterialList(int dealerID){

        return dao().showMyMaterials(dealerID);
    }

    public static Material showMaterial(int materialID){
        
        return dao().findMaterial(materialID);
    }

}