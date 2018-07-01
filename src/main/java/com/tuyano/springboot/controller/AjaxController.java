package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	  
	// メインメニューの初期表示
	@RequestMapping(value = "/Ajax/AjaxList")
	public String index() {
		return "/ajax/ajaxList";
	}

}
