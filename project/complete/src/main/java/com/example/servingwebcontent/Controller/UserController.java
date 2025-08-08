package com.example.servingwebcontent.Controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.RuntimeException;
import java.util.ArrayList;

import com.example.servingwebcontent.Component.ListUser;
import com.example.servingwebcontent.Component.WriteToFile;
import com.example.servingwebcontent.Database.aivenConnection;
import com.example.servingwebcontent.Database.insertToAiven;
import com.example.servingwebcontent.Model.User;




@Controller
public class UserController {

	@GetMapping("/useradd")
	public String User( Model model) {
      model.addAttribute("User", new User());
		
		return "useradd";
	}


	@PostMapping("/usersave")
    @ResponseBody
	public String SaveData( 
			Model model, @ModelAttribute User User)  {
				System.out.println("Hello addresss :::" +User);

        model.addAttribute("User", User); // Add populated object back to model for display

       
		try {
			
			
				//model.addAttribute("name", fname);
				//model.addAttribute("address",address);

				User u = new User();
				u.setUserName(User.getUserName());
				u.setAddress(User.getAddress());
				u.setUserID(User.getUserID());
				
				ArrayList<User> al = new ArrayList<User>();
				al.add(u);

				
				insertToAiven iu = new insertToAiven();
				iu.insertToAivenDb(u);
				model.addAttribute("listOfArray", al);
				
			

		} catch (RuntimeException e) {

			System.out.println(e);

		} finally {
			System.out.println("done");

		}

		return "greeting";
	}

}
