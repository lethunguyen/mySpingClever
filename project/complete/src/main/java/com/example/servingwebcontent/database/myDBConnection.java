package com.example.servingwebcontent.database;

import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;

@Controller
public class myDBConnection {
    myDBConnection() {
    };

    @Value("${my.database.url}")
    protected String myDatabaseURL;

    @Value("${my.database.driver}")
    protected String myDatabaseDriver;

   // Connection getconn = null;
      Connection conn = null;
    public Statement getMyConn() {
      

        try {
            // Class.forName(myDatabaseDriver);

            // getconn = DriverManager.getConnection(myDatabaseURL);

            // Statement sta = getconn.createStatement();

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                    "sqluser", "password");
            Statement sta = conn.createStatement();
            return sta;
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("myDBConnection at34");

        }

        return null;

    }

}
