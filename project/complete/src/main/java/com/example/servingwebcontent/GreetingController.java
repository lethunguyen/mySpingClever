package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="OOP Class !") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/test")
	public String test(@RequestParam(name = "test", required=false, defaultValue="test") String test, Model model){

		model.addAttribute("test", test);

		System.out.println("t:"+test);
		return "test";
	}

}
