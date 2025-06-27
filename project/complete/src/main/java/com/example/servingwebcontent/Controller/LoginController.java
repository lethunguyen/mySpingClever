package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.RuntimeException;
import java.util.ArrayList;

import com.example.servingwebcontent.Component.ListUser;
import com.example.servingwebcontent.Component.WriteToFile;
import com.example.servingwebcontent.Database.aivenConnection;
import com.example.servingwebcontent.Database.insertToAiven;
import com.example.servingwebcontent.Model.User;



@Controller
public class LoginController {

	@GetMapping("/Login")

	public String login(@RequestParam String fname, 
			@RequestParam String address, Model model) {

		try {
			System.out.println(fname);
			
			if (fname.equals("")) {
				System.out.println("No name");

			} else {
				model.addAttribute("name", fname);
				model.addAttribute("address", address);
				User u = new User();
				u.setUserName(fname);
				u.setAddress(address);
				
				ArrayList<User> al = new ArrayList<User>();
				
				al.add(u);

				ListUser lu = new ListUser();
				lu.printListUser(al);
				
				model.addAllAttributes(al);
				WriteToFile wf = new WriteToFile();
				wf.ToFile(al);
				insertToAiven iu = new insertToAiven();
				iu.insertToAivenDb(u);
				aivenConnection ac = new aivenConnection();
				ac.aivenConn();
				

			}

		} catch (RuntimeException e) {

			System.out.println(e);

		} finally {
			System.out.println("done");

		}

		return "greeting";
	}


	@PostMapping("/Login")

	public String SaveData( 
			Model model, @RequestBody  String address, @RequestBody String fname)  {
				System.out.println("Hello addresss :::" +address);
                System.out.println("Hello addresss :::" + fname);
		try {
			
			
				model.addAttribute("name", fname);
				model.addAttribute("address",address);
				User u = new User();
				u.setUserName(fname);
				u.setAddress(address);
				
				ArrayList<User> al = new ArrayList<User>();
				al.add(u);

				
				insertToAiven iu = new insertToAiven();
				iu.insertToAivenDb(u);
				

			

		} catch (RuntimeException e) {

			System.out.println(e);

		} finally {
			System.out.println("done");

		}

		return "greeting";
	}

}
