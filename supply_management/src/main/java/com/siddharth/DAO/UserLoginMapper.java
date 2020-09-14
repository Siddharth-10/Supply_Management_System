package com.siddharth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.siddharth.Model.UserLogin;
import com.siddharth.Model.UserType;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class UserLoginMapper implements ResultSetMapper<UserLogin> {

    public UserLogin map(int idx, ResultSet rs, StatementContext ctx) throws SQLException{

        String userTypeString = rs.getString("USERTYPE");
        UserType userType;

        if(userTypeString.equals("ADMIN")){
            userType = UserType.ADMIN;
        }
        else if(userTypeString.equals("CLIENT")){
            userType = UserType.CLIENT;
        }
        else{
            userType = UserType.DEALER;
        }

        return new UserLogin(rs.getString("USERNAME"), rs.getString("USER_PASSWORD"), userType, rs.getInt("USER_ID"));
    }

}