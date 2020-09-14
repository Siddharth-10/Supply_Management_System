package com.siddharth.DAO;

import java.util.List;

import com.siddharth.Model.Client;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface ClientDAO {

    @SqlQuery("select * from Client")
    @Mapper(ClientMapper.class)
    List<Client> show();

    @SqlUpdate("insert into client(CLIENT_ID,CLIENT_NAME,CLIENT_DOB,CLIENT_PN,CLIENT_RATING,CLIENT_ADDRESS) values(:c.id, :c.name, :c.dateOfBirth,"
            +":c.contactInfo, :c.rating, :c.address)")
    void insert(@BindBean("c") Client client);

    @SqlUpdate("update client set CLIENT_NAME =:c.clientName,"
            +"CLIENT_DOB =:c.clientDateOfBirth, CLIENT_PN =:c.clientPhontNumber,"
            +"CLIENT_RATING =:c.clientRating, CLIENT_ADDRESS =:c.clientAddress where CLIENT_ID =:c.clientID")
    void update(@BindBean("c") Client client);

    @SqlUpdate("delete from client where CLIENT_ID =:clientID")
    void delete(@Bind("clientID") int clientID);

    @SqlQuery("select * from Client where CLIENT_ID =:clientID")
    @Mapper(ClientMapper.class)
    Client find(@Bind("clientID") int clientID);

}