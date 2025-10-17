package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.servingwebcontent.Component.WriteToFile;
import com.example.servingwebcontent.Model.User;

@Controller
public class GreetingController {

	

	@GetMapping("/")
	public String User(Model model) {
		User u = new User("test", "hanoi");
		WriteToFile test = new WriteToFile();
		System.out.println("username::"+u.getUserName());
		test.ToFileUser(u.getUserName());
	
		model.addAttribute("User", u);

		return "hello";
	}

	@GetMapping("/test")
	public String test(@RequestParam(name = "test", required = false, defaultValue = "test") String test, Model model) {

		model.addAttribute("test", test);

		System.out.println("t:" + test);
		return "test";
	}

}
