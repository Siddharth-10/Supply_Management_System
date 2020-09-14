package com.siddharth.Model;

public class UserLogin{
    private String userName;
    private String password;
    private UserType userType;
    private int userID;

public UserLogin(){
    
}

public UserLogin(String userName,String password,UserType userType,int UserID){
    this.userName=userName;
    this.password=password;
    this.userType=userType;
    this.userID=UserID;
}

public void setUserName(String userName){
    this.userName=userName;
}
public String getUserName(){
    return this.userName;
}

public void setPassword(String password){
    this.password=password;
}
public String getPassword(){
    return this.password;
}
public void setUserType(UserType userType){
    this.userType=userType;
}
public UserType getUserType(){
    return this.userType;
}

public void setUserID(int UserID){
    this.userID=UserID;
}
public int getUserID(){
    return this.userID;
}

}

