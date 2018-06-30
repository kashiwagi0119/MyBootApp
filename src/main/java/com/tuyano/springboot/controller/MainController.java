package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	  
	// メインメニューの初期表示
	@RequestMapping(value = "")
	public String index() {
		return "index";
	}

}
