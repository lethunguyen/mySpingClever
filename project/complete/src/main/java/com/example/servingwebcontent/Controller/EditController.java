package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditController {

	@GetMapping("/edit/{id}")
	public String greeting(@PathVariable String id, Model model) {
		model.addAttribute("name", id);
		System.out.println("User id: "+ id);
		return "greeting";
	}

}
