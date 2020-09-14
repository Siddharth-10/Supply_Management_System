package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.siddharth.Model.ClientCart;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ClientCartMapper implements ResultSetMapper<ClientCart>{

    public ClientCart map(int idx, final ResultSet rs, StatementContext ctx) throws SQLException{

        return new ClientCart(rs.getInt("CLIENT_ID"),rs.getInt("MATERIAL_ID"), rs.getString("MATERIAL_NAME"), rs.getInt("DEALER_ID"), rs.getFloat("MATERIAL_PRICE"), rs.getInt("MATERIAL_QUANTITY"), rs.getString("MATERIAL_QUALITY"));
    }
    
}