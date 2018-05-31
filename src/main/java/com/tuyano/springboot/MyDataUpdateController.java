package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;

@Controller
public class MyDataUpdateController {
	  
	@Autowired
	MyDataRepository repository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	private MyDataService service;
	@Autowired
	MyDataForm formSession;
    
	@RequestMapping(value = "/MyData/update")
	public String update(@ModelAttribute("mydata") MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/MyData/search";
	}


}
