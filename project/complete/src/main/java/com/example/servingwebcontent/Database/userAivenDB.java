package com.example.servingwebcontent.Database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.example.servingwebcontent.Model.Song;
import com.example.servingwebcontent.Model.User;

@Controller
public class userAivenDB {

    @Value("${my.database.url}")
    private String urlString;

    @Value("${my.database.driver}")
    private String myDriver;

    public userAivenDB() {
    }

    /*
     * mapping database data to Model User
     */

    User item = new User();

    /**
     * @return
     */
    public User userSearch(String id) {
        try {

            myDBConnection my = new myDBConnection();
            Connection conn = my.getOnlyConn();

            PreparedStatement statement = conn.prepareStatement("select * from user where userID = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            int index = 0;
            int columnCount = resultSet.getMetaData().getColumnCount();

            System.out.println("size query::" + resultSet.getFetchSize());
            System.out.println("column edit function #" + columnCount);

            String userID = resultSet.getString("userID");
            String userName = resultSet.getString("userName");
            String address = resultSet.getString("address");

            item.setUserID(userID);
            item.setUserName(userName);
            item.setAddress(address);

            System.out.println(index);

            resultSet.close();

            conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion :" + e);

            e.printStackTrace();
        }

        System.out.println("edit:::" + item.getUserName());

        return item;

    }

    public void userDelete(String id) {
        try {

            myDBConnection my = new myDBConnection();
            Connection conn = my.getOnlyConn();

            PreparedStatement statement = conn.prepareStatement("delete from user where userID = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion :" + e);
            e.printStackTrace();
        }

    }

}
