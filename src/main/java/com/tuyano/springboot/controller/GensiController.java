package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GensiController {

	@RequestMapping(value = "/gensi")
	public String index(Model model) {

    	model.addAttribute("msg0", "aaaaa");
    	model.addAttribute("msg2", "bbbbb");

		return "/gensi";
	}




}
