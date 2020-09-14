package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.Dealer;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface DealerDAO {

    @SqlQuery("select * from Dealer")
    @Mapper(DealerMapper.class)
    List<Dealer> show();

    @SqlUpdate("insert into dealer values(:d.dealerID,:d.dealerName,:d.address,"
                +":d.dealerPhoneNumber,:d.dealerEmail,:d.rating)")
    void insert(@BindBean("d") Dealer dealer);

    @SqlUpdate("update dealer set DEALER_NAME =:d.dealerName,"
            +" DEALER_ADDRESS =:d.dealerAddress, DEALER_PN =:d.dealerPhoneNumber,"+
            "DEALER_EMAIL =:d.dealerEmail, DEALER_RATING =:d.dealerRating where DEALER_ID =:d.dealerID")
    void update(@BindBean("d") Dealer dealer);

    @SqlUpdate("delete from dealer where DEALER_ID =:dealerID")
    void delete(@Bind("dealerID") int dealerID);

    @SqlQuery("select * from Dealer where DEALER_ID =:dealerID")
    @Mapper(DealerMapper.class)
    Dealer find(@Bind("dealerID") int dealerID);
    
}