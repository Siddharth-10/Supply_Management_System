package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.siddharth.Model.Client;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ClientMapper implements ResultSetMapper<Client>{

    public Client map(int idx,final ResultSet rs, StatementContext ctx) throws SQLException {

        return new Client(rs.getInt("CLIENT_ID"),rs.getString("CLIENT_NAME"),rs.getDate("CLIENT_DOB"),rs.getString("CLIENT_PN"),rs.getFloat("CLIENT_RATING"),rs.getString("CLIENT_ADDRESS"));

    }
    
}