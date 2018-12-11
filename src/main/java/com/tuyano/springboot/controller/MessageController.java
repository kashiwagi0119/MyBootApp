package com.tuyano.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuyano.springboot.MyMessageSource;

@Controller
public class MessageController {

	@Autowired
	MyMessageSource msg;

	@RequestMapping(value = "/message")
	public String index(Model model) {

    	// メッセージプロパティの取得
    	String msg0 = msg.getMessage("my.msg0");
    	System.out.println(msg0);
    	String msg2 = msg.getMessage("my.msg2", "aaa", "bbb");
    	System.out.println(msg2);

    	model.addAttribute("msg0", msg0);
    	model.addAttribute("msg2", msg2);

		return "/message";
	}




}
