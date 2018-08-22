package com.tuyano.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.constant.Check2Enum;
import com.tuyano.springboot.constant.Radio1Enum;
import com.tuyano.springboot.constant.SelectEnum;
import com.tuyano.springboot.dto.JsonResultDTO;
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
public class MyDataController {
	  
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
	@RequestMapping(value = "/MyData/list")
	public String myDataList(Model model, MyDataForm form) {
		return "/myData/myDataList";
	}
	
	// DSLで検索
	@RequestMapping(value = "/MyData/searchDSL")
	@ResponseBody
	public JsonResultDTO searchDSL(Model model, MyDataForm form) {
		Iterable<MyData> list = new ArrayList<MyData>();
//		Iterable<MyData> list = service.findDSL(form);
		JsonResultDTO jsonResult = new JsonResultDTO();
//		jsonResult.addMessage("メッセージ１");
//		jsonResult.addMessage("メッセージ２");
//		jsonResult.addMessage("メッセージ３");
//		jsonResult.addError("エラーメッセージ１");
//		jsonResult.addError("エラーメッセージ２");
//		jsonResult.addError("エラーメッセージ３");
		jsonResult.setDataList(list);
		return jsonResult;
	}
	
	// Criteriaで検索
	@RequestMapping(value = "/MyData/search")
	@ResponseBody
	public JsonResultDTO searchCriteria(Model model, MyDataForm form) {
		List<MyData> list = service.findCriteria(form);
		JsonResultDTO jsonResult = new JsonResultDTO();
//		jsonResult.addMessage("メッセージ１");
//		jsonResult.addMessage("メッセージ２");
//		jsonResult.addMessage("メッセージ３");
//		jsonResult.addError("エラーメッセージ１");
//		jsonResult.addError("エラーメッセージ２");
//		jsonResult.addError("エラーメッセージ３");
		jsonResult.setDataList(list);
		return jsonResult;
	}

	// repositoryで検索
	@RequestMapping(value = "/MyData/searchRepository")
	public String searchRepository(Model model, MyDataForm form) {
		// 単純な検索ならServiceを経由しなくもいいかな
		List<MyData> list = repository.findByNameOrderByIdDesc(form.getName());
		model.addAttribute("datalist", list);
		return "/myData/myDataList";
	}
	
	// Specificationで検索
	@RequestMapping(value = "/MyData/searchSpecification")
	public String searchSpecification(Model model, MyDataForm form) {
		
		List<MyData> list = new ArrayList<MyData>();
//		List<MyData> list = service.findSpecification(form);
		model.addAttribute("datalist", list);
		return "/myData/myDataList";
	}
	
	// JPQLで検索
	@RequestMapping(value = "/MyData/searchJPQL")
	public String searchJPQL(Model model, MyDataForm form) {
		
		List<MyData> list = service.findJPQL(form);
		model.addAttribute("datalist", list);
		return "/myData/myDataList";
	}
	
	// SQLで検索
	@RequestMapping(value = "/MyData/searchSQL")
	public String searchSQL(Model model, MyDataForm form) {
		
		List<MyData> list = service.findSQL(form);
		model.addAttribute("datalist", list);
		return "/myData/myDataList";
	}
	
	// 新規登録画面へ
	@RequestMapping(value = "/MyData/insertwindow")
	public String insertwinddow(Model model, MyDataForm form) {
		model.addAttribute("mydata", new MyData());
		return "/myData/myDataInsert";
	}
	
	// 削除ボタン
	@RequestMapping(value = "/MyData/delete/{id}")
	public String delete(Model model, MyDataForm form, @PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/MyData/search";
	}
	
	// 更新画面へ
	@RequestMapping(value = "/MyData/updatewindow/{id}")
	public String updatewindow(Model model, MyDataForm form, @PathVariable Long id) {
		Optional<MyData> data = repository.findById(id);
		model.addAttribute("mydata",data.get());
		return "/myData/myDataUpdate";
	}
	
	// 新規登録画面の登録ボタン
	@RequestMapping(value = "/MyData/insert")
	public String insert(Model model, MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/MyData/list";
	}
	
	 // 更新画面の更新ボタン
	@RequestMapping(value = "/MyData/update")
	public String update(MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/MyData/list";
	}
	
	// 新規登録画面・更新画面の戻るボタン
	@RequestMapping(value = "/MyData/back")
	public String back(Model model) {
		return "redirect:/MyData/list";
	}

}
