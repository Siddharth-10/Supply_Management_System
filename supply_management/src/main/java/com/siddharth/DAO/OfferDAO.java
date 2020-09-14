package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface OfferDAO {

    @SqlQuery("select * from offer where DEALER_ID=:dealerID")
    @Mapper(OfferMapper.class)
    List<Offer> showDealer(@Bind("dealerID") int dealerID);

    @SqlUpdate("insert into offer values(:o.clientID, :o.dealerID, :o.materialID, :o.price, :o.offerStatus)")
    void insert(@BindBean("o") Offer offer);

    @SqlQuery("select * from offer where CLIENT_ID=:clientID and MATERIAL_ID =:materialID")
    @Mapper(OfferMapper.class)
    List<Offer> showClient(@Bind("clientID") int clientID, @Bind("materialID") int materialID);

    @SqlUpdate("update offer set OFFER_STATUS=:status where CLIENT_ID=:clientID and MATERIAL_ID =:materialID and PRICE=:price and DEALER_ID =:dealerID")
    void updateStatus(@Bind("clientID") int clientID,@Bind("dealerID") int dealerID, @Bind("materialID") int materialID, @Bind("price") int price,@Bind("status") OfferStatus status);
}