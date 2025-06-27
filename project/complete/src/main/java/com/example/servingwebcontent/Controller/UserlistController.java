package com.example.servingwebcontent.Controller;
import com.example.servingwebcontent.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;



@Controller
public class UserlistController {

	@GetMapping("/userlist")
	public String userlist(Model model) {

		ArrayList<User> listOfArray = new ArrayList<User>();
		userAiven ua = new userAiven();
		listOfArray = ua.userAivenList();

		model.addAttribute("listOfArray", listOfArray);

		return "userlist";
	}

}