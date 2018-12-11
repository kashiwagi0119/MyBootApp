package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SyserrorController {

	@RequestMapping(value = "/syserror")
	public String index(Model model) {

    	model.addAttribute("msg0", "aaaaa");
    	model.addAttribute("msg2", "bbbbb");

		return "/syserror";
	}

	@RequestMapping(value = "/syserrorsub")
	public String syserrorsub(Model model) {

		long errtest = 1L / 0L;

		return "/syserror";
	}




}
