package com.tuyano.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuyano.springboot.constant.Check2Enum;
import com.tuyano.springboot.constant.Radio1Enum;
import com.tuyano.springboot.constant.SelectEnum;
import com.tuyano.springboot.dto.JsonResultDTO;
import com.tuyano.springboot.entity.Item;
import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.entity.Room;
import com.tuyano.springboot.form.MyDataForm;
import com.tuyano.springboot.form.MyDataFormMini;
import com.tuyano.springboot.repositories.ItemRepository;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;
import com.tuyano.springboot.service.MyDataService;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.TypeReference;

@Controller
@SessionAttributes(value = "myDataForm")
public class MyDataGridController {
	  
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
	
	// 検索画面の初期表示
	@RequestMapping(value = "/MyDataGrid/list")
	public String myDataList(Model model, MyDataForm form) {
		return "/myDataGrid/myDataGrid";
	}
	
	// 送信ボタン
	@RequestMapping(value = "/MyData/myDataGridSend")
	@ResponseBody
	public JsonResultDTO searchDSL(String json, String orderStatus)  {
		
		// 複数行LIST
		List<MyDataFormMini> dtoList = new ArrayList<MyDataFormMini>();
		dtoList = JSON.decode(json, new TypeReference<List<MyDataFormMini>>() {});
		   
//		// 1行
//		MyDataFormMini aaa = JSON.decode(json, MyDataFormMini.class);
		   
		JsonResultDTO jsonResult = new JsonResultDTO();
		return jsonResult;
	}

}
