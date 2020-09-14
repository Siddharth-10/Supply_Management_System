package com.siddharth.Factory;

import com.siddharth.DAO.DbConnection;
import com.siddharth.DAO.UserLoginDAO;
import com.siddharth.Model.UserLogin;

public class UserLoginFactory {

    private static UserLoginDAO dao() {

        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(UserLoginDAO.class);
    }

    public static int checkUsername(String userName) {

        return dao().findUsername(userName);
    }

    public static UserLogin getUserLogin(String username) {
        return dao().getData(username);
    }

    public static String getPassword(String username) {
        return dao().getPassword(username);
    }

    public static void insertUserLogin(UserLogin userLogin){
        String userType =  userLogin.getUserType().name();
        dao().insert(userLogin,userType);

    }

    public static void updateUserLogin(UserLogin userLogin){
        dao().update(userLogin);
    }

    public static void deleteUserLogin(int userID){
        dao().delete(userID);
    }

    public static int checkUserID(int userID){
        return dao().findUserID(userID);
    }

}