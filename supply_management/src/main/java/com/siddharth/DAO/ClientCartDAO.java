package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.ClientCart;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface ClientCartDAO {

    @SqlQuery("select * from clientCart where CLIENT_ID =:clientID")
    @Mapper(ClientCartMapper.class)
    List<ClientCart> showList(@Bind("clientID") int clientID);

    @SqlUpdate("insert into clientCart values(:m.clientID,:m.materialID, :m.materialName, :m.dealerID,"
    +":m.materialPrice, :m.materialQuantity, :m.materialQuality)")
    void insert(@BindBean("m") ClientCart clientCart);

    @SqlQuery("select exists(select * from clientCart where Material_ID =:materialID and CLIENT_ID =:clientID)")
    int find(@Bind("materialID") int materialID,@Bind("clientID") int clientID);

    @SqlQuery("select * from clientCart where CLIENT_ID =:clientID and MATERIAL_ID =:materialID")
    @Mapper(ClientCartMapper.class)
    ClientCart showMaterial(@Bind("materialID") int materialID,@Bind("clientID") int clientID);

    @SqlUpdate("update clientcart set MATERIAL_PRICE=:price where CLIENT_ID =:clientID and DEALER_ID=:dealerID and MATERIAL_ID =:materialID")
    void updatePrice(@Bind("price") int price, @Bind("clientID") int clientID, @Bind("dealerID") int dealerID, @Bind("materialID") int materialID);
    
}