package com.tuyano.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.constant.Check2Enum;
import com.tuyano.springboot.constant.Radio1Enum;
import com.tuyano.springboot.constant.SelectEnum;
import com.tuyano.springboot.entity.Item;
import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.entity.Room;
import com.tuyano.springboot.form.MyDataForm;
import com.tuyano.springboot.repositories.ItemRepository;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;
import com.tuyano.springboot.service.MyDataService;

@Controller
@SessionAttributes(value = "myDataForm")
public class PartsController {
	  
	@Autowired
	MyDataRepository repository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	private MyDataService service;
	
	@ModelAttribute("selectEnums")
	SelectEnum[] selectEnum() {
		return SelectEnum.values();
	}
	
	@ModelAttribute("Check2Enum")
	Check2Enum[] Check2Enum() {
		return Check2Enum.values();
	}
	
	@ModelAttribute("Radio1Enum")
	Radio1Enum[] Radio1Enum() {
		return Radio1Enum.values();
	}
	
	@ModelAttribute("selectRooms")
	List<Room> selectRooms() {
		return roomRepository.findAll();
	}
	
	@ModelAttribute("selectItems")
	List<Item> selectItems() {
		return itemRepository.findAll();
	}
	
	@RequestMapping(value = "/Parts")
	public String parts(Model model) {
		MyDataForm myDataForm = new MyDataForm();
		myDataForm.setName2("プレーンテキストの表示");
		model.addAttribute("myDataForm", myDataForm);
		return "parts/parts";
	}

}
