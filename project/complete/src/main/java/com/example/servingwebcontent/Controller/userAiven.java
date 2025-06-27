package com.example.servingwebcontent.Controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import org.springframework.stereotype.Controller;

import com.example.servingwebcontent.Database.myDBConnection;
import com.example.servingwebcontent.Model.User;

@Controller
public class userAiven {

    ArrayList<User> items = new ArrayList<User>();
   
    public ArrayList<User> userAivenList() {

        try {

            myDBConnection my = new myDBConnection();
            Statement sta = my.getMyConn();

            ResultSet setdata = sta.executeQuery("select * from user");
            int index = 0;
            int columnCount = setdata.getMetaData().getColumnCount();
            System.out.println("column #" + columnCount);

            while (setdata.next()) {
                User user = new User();

                String userID = setdata.getString("userId");

                String username = setdata.getString("username");

                String address = setdata.getString("address");
                System.out.println("USER AIVEN TEST:");
                System.out.println(userID + " " + username + " " + address);

                user.setUserID(userID);
                user.setUserName(username);
                user.setAddress(address);

                System.out.println("Get username in user Aiven");
                System.out.println(user.getUserName());
                System.out.println(index);

                items.add(user);
            }

            setdata.close();
            sta.close();
            //can phuong thuc close
            //conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }

        return items;

    }

}
