package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.servingwebcontent.Database.songSearchAiven;
import com.example.servingwebcontent.Model.Song;

import java.util.ArrayList;

//controller to song search
@Controller
public class SongSearchController {


    @GetMapping("/search")

    public String songSearchList(Model model, @RequestParam String songName) {

        ArrayList<Song> songList = new ArrayList<Song>();
        songSearchAiven sa = new songSearchAiven();
        
        songList = sa.songAivenSearch(songName);
        model.addAttribute("ListOfSong", songList);

        // data to View is ${ListOfSong}

        // return view is songList
        return "songlist";

    }

    @GetMapping("/getSearch")

    public String songSearchList(Model model) {

        return "search";

    }

}
