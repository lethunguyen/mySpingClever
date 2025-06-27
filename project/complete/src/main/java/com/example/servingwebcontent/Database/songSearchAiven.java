package com.example.servingwebcontent.Database;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.example.servingwebcontent.Model.Song;

@Controller
public class songSearchAiven {

    @Value("${my.database.url}") 
    private String urlString;

    @Value("${my.database.driver}")
    private String myDriver;

    public songSearchAiven() {
    }

    /* 
     * mapping database data to Model Song
     */

    ArrayList<Song> items = new ArrayList<Song>();

    /**
     * @return
     */
    public ArrayList<Song> songAivenSearch(String songName) {

        try {

            myDBConnection my = new myDBConnection();
            Connection conn = my.getOnlyConn();

            PreparedStatement statement = conn.prepareStatement("select * from song where songName = ?");
            statement.setString(1, songName);
            ResultSet resultSet = statement.executeQuery();

            int index = 0;
            int columnCount = resultSet.getMetaData().getColumnCount();
            System.out.println("column #" + columnCount);

            while (resultSet.next()) {
                Song song = new Song();

                String songID = resultSet.getString("songID");

                // String songName = resultSet.getString("songName");

                String songAuthor = resultSet.getString("songAuthor");

                String country = resultSet.getString("country");

         
                System.out.println("Song search AIVEN TEST:"+ songID + " " + songName + " " + songAuthor);

                song.setSongID(songID);
                song.setSongName(songName);
                song.setSongAuthor(songAuthor);
                song.setSongCountry(country);

                System.out.println("Get SONG in song Aiven : "+ song.getSongName());
          
                System.out.println(index);

                items.add(song);
            }

            resultSet.close();

            conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion :" + e );
           
            e.printStackTrace();
        }

        return items;

    }

}
