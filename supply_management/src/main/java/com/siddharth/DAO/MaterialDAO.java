package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.Material;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface MaterialDAO {

    @SqlQuery("select * from material")
    @Mapper(MaterialMapper.class)
    List<Material> show();

    @SqlUpdate("insert into material values(:m.materialID, :m.materialName, :m.dealerID,"
            +":m.materialPrice, :m.materialQuantity, :m.materialQuality)")
    void insert(@BindBean("m") Material material);

    @SqlUpdate("update material set MATERIAL_NAME =:m.materialName,"
            +"DEALER_ID =:m.dealerID, MATERIAL_PRICE =:m.materialPrice, MATERIAL_QUANTITY =:m.materialQuantity,"
            +"MATERIAL_QUALITY =:m.materialQuality where MATERIAL_ID =:m.materialID")
    void update(@BindBean("m") Material material);

    @SqlUpdate("delete from material where MATERIAL_ID =:materialID")
    void delete(@Bind("materialID") int materialID);

    @SqlQuery("select exists(select * from material where MATERIAL_ID =:materialID)")
    int find(@Bind("materialID") int materialID);

    @SqlQuery("select * from material where DEALER_ID = :dealerID")
    @Mapper(MaterialMapper.class)
    List<Material> showMyMaterials(@Bind("dealerID") int dealerID);

    @SqlQuery("select * from material where MATERIAL_ID =:materialID")
    @Mapper(MaterialMapper.class)
    Material findMaterial(@Bind("materialID") int materialID);
    
}