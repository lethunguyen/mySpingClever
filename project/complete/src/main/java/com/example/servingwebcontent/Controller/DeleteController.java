package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.servingwebcontent.Database.userAivenDB;
import com.example.servingwebcontent.Database.userSearchAiven;
import com.example.servingwebcontent.Model.User;

@Controller
public class DeleteController {

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable String id, Model model) {
		model.addAttribute("name", id);
		System.out.println("User id: " + id);

		// model user with id

		User user = new userAivenDB();
		user.deleteUser(id);

		System.out.println("username:::"+user.getUserName());

		model.addAttribute("User", user);

		return "useredit";
	}

}
