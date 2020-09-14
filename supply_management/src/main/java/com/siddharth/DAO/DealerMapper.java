package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.siddharth.Model.Dealer;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class DealerMapper implements ResultSetMapper<Dealer>{

    public Dealer map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {

        return new Dealer(rs.getInt("DEALER_ID"),rs.getString("DEALER_NAME"),rs.getString("DEALER_ADDRESS"),rs.getString("DEALER_PN"),rs.getString("DEALER_EMAIL"),rs.getFloat("DEALER_RATING"));

    }

}