package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
//import java.util.List;



import com.example.servingwebcontent.Song;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class songAiven {


  
    @Value("${my.test}") 
    private String urlString;

    @Value("${my.database.driver}")
    private String myDriver;
   
//phan write to bien 33 khong lam viec
    

    /*
     * to do
     * mapping database data to Model Song
     */

    ArrayList<Song> items = new ArrayList<Song>();

    public ArrayList<Song> songAivenList() {

      

        Connection conn = null;
        try {

            Class.forName(myDriver);
             conn = DriverManager.getConnection(
             urlString);

           // conn = DriverManager.getConnection(conn);
            Statement sta = conn.createStatement();

            ResultSet setdata = sta.executeQuery("select * from song limit 10");
            int index = 0;
            int columnCount = setdata.getMetaData().getColumnCount();
            System.out.println("column #" + columnCount);

            while (setdata.next()) {
                Song song = new Song();

                String songID = setdata.getString("songID");

                String songName = setdata.getString("songName");

                String songAuthor = setdata.getString("songAuthor");

                String country = setdata.getString("country");

                System.out.println("Song AIVEN TEST:");
                System.out.println(songID + " " + songName + " " + songAuthor);

                song.setSongID(songID);
                song.setSongName(songName);
                song.setSongAuthor(songAuthor);
                song.setSongCountry(country);

                System.out.println("Get SONG in song Aiven");
                System.out.println(song.getSongName());
                System.out.println(index);

                items.add(song);
            }

            setdata.close();
            sta.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }

        return items;

    }

}
