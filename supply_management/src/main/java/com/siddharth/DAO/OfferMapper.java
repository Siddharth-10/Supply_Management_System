package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.siddharth.Model.Offer;
import com.siddharth.Model.OfferStatus;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


public class OfferMapper implements ResultSetMapper<Offer> {

    public Offer map(int idx, ResultSet rs, StatementContext ctx) throws SQLException{

        String offerStatusString = rs.getString("OFFER_STATUS");
        OfferStatus offerStatus;

        if(offerStatusString.equals("ACCEPT")){
            offerStatus = OfferStatus.ACCEPT;
        }
        else if(offerStatusString.equals("REJECT")){
            offerStatus = OfferStatus.REJECT;
        }
        else{
            offerStatus = OfferStatus.PENDING;
        }

        return new Offer(rs.getInt("CLIENT_ID"),rs.getInt("DEALER_ID"),rs.getInt("MATERIAL_ID"),rs.getInt("PRICE"),offerStatus);
    }
    
}