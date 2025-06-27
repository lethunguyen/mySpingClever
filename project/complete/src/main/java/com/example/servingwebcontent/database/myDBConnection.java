package com.example.servingwebcontent.database;

import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;

@Controller
public class myDBConnection {
    myDBConnection(){};

    @Value("${my.database.url}")
    private String myDatabaseURL;

    @Value("${my.database.driver}")
    private String myDatabaseDriver;

    Connection getconn = null;

    public Statement getMyConn(){

        try {
            Class.forName(myDatabaseDriver);

            getconn = DriverManager.getConnection(myDatabaseURL);

            Statement sta = getconn.createStatement();
            return sta;
        } catch (Exception e) {
            System.out.println(e);

        }

         return null;

    }

}
