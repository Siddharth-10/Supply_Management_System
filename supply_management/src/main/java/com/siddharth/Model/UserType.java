package com.siddharth.Model;

public enum UserType{
    ADMIN("ADMIN"),
    CLIENT("CLIENT"),
    DEALER("DEALER");

    private String userTypeName;

    private UserType(String userTypeName){
        this.userTypeName = userTypeName;
    }
}