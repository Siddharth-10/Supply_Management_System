package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.siddharth.Model.Material;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MaterialMapper implements ResultSetMapper<Material> {

    public Material map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
        return new Material(rs.getInt("MATERIAL_ID"), rs.getString("MATERIAL_NAME"), rs.getInt("DEALER_ID"), rs.getFloat("MATERIAL_PRICE"), rs.getInt("MATERIAL_QUANTITY"), rs.getString("MATERIAL_QUALITY"));
    }
    
}