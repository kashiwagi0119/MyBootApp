package com.tuyano.springboot;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;

@Controller
public class InsertController {
	  
	@Autowired
	MyDataRepository repository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	private MyDataService service;
	@Autowired
	HttpSession session;
	@Autowired
	MyDataForm myDataForm;
	
//	@RequestMapping(value = "/insertwindow")
//	public String insertwinddow(Model model) {
//		// セレクトボックス設定
//		model.addAttribute("selectItems", roomRepository.findAll());
//		model.addAttribute("mydata", new MyData());
//		return "insert";
//	}
	
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute("mydata") MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/search";
	}
	
	@RequestMapping(value = "/back")
	public String back() {
		return "redirect:/search";
	}
	

}
