package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.UserLogin;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface UserLoginDAO {

    @SqlQuery("select * from userlogin")
    @Mapper(UserLoginMapper.class)
    List<UserLogin> show();

    @SqlUpdate("insert into userlogin(USERNAME,USER_PASSWORD,USERTYPE,USER_ID) values(:u.userName,:u.password,:userType,:u.userID)")
    void insert(@BindBean("u") UserLogin userLogin,@Bind("userType") String userType);

    @SqlUpdate("update userlogin set USER_PASSWORD =:u.password , USERTYPE = u.userType, USER_ID =:u.userID "
                +"where USERNAME = u.userName")
    void update(@BindBean("u") UserLogin userLogin);

    @SqlUpdate("delete from userlogin where USER_ID =:userID")
    void delete(@Bind("userID") int userID);

    @SqlQuery("select exists( select * from userlogin where USERNAME = :username);")
    int findUsername(@Bind("username") String userName);

    @SqlQuery("select * from userlogin where USERNAME =:username")
    @Mapper(UserLoginMapper.class)
    UserLogin getData(@Bind("username") String userName);

    @SqlQuery("select USER_PASSWORD from userlogin where USERNAME =:username")
    String getPassword(@Bind("username") String userName);

    @SqlQuery("select exists( select * from userlogin where USER_ID =:userID)")
    int findUserID(@Bind("userID") int userID);
    
}