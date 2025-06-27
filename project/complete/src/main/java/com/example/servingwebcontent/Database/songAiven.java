package com.example.servingwebcontent.Database;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;

import com.example.servingwebcontent.Model.Song;



@Controller
public class songAiven {
    
    ArrayList<Song> items = new ArrayList<Song>();

    public ArrayList<Song> songAivenList() {

        try {

            myDBConnection my = new myDBConnection();
            Statement sta = my.getMyConn();

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
            //my.close();

        } catch (Exception e) {
            System.out.println("Error in database connecion :" + e);
            e.printStackTrace();
        }

        return items;

    }

}
