package com.example.servingwebcontent.Component;
import com.example.servingwebcontent.Database.insertToAiven;
import com.example.servingwebcontent.Model.User;



public class WriteToSQLDb {
    public void writeToDb(User u){
        insertToAiven ac = new insertToAiven();
		ac.insertToAivenDb(u);
    }
    
}
