package com.tuyano.springboot;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;

@Controller
public class HeloController {
	  
	@Autowired
	MyDataRepository repository;
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	private MyDataService service;

	/**
	 * check boxの表示に使用するアイテム
	 */
	@SuppressWarnings("serial")
	final static Map<String, String> CHECK_ITEMS =
		Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		{
		  put("チェック複数1", "1");
		  put("チェック複数2", "2");
		  put("チェック複数3", "3");
		}
	});
	  
	/**
	 * radio buttonの表示に使用するアイテム
	 */
	@SuppressWarnings("serial")
	final static Map<String, String> RADIO_ITEMS =
	    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	    {
	      put("ラジオ1", "1");
	      put("ラジオ2", "2");
	      put("ラジオ3", "3");
	    }
	});
	  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute("formModel") MyDataForm mydataForm) {
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		Iterable<MyData> list = repository.findAll();
		model.addAttribute("datalist", list);
		return "index";
	}

	@RequestMapping(value = "/search")
	public String search(Model model, @ModelAttribute("formModel") MyDataForm mydataForm) {
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		List<MyData> list = service.findMyDatas(mydataForm);
		model.addAttribute("datalist", list);
		return "index";
	}
	
	@RequestMapping(value = "/insertwindow")
	public String insertwinddow(Model model, @ModelAttribute("formModel") MyDataForm mydataForm) {
		// セレクトボックス設定
		model.addAttribute("selectItems", roomRepository.findAll());
		return "insert";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(Model model, @ModelAttribute("formModel") MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/back")
	public String back(Model model) {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String update(Model model, @PathVariable Long id) {
		Optional<MyData> data = repository.findById(id);
		model.addAttribute("formModel",data.get());
		// セレクトボックス設定
		model.addAttribute("selectItems", roomRepository.findAll());
		return "update";
	}
    
	@RequestMapping(value = "/update")
	public String update(Model model, @ModelAttribute("formModel") MyData mydata) {
		repository.saveAndFlush(mydata);
		return "forward:/search";
	}
	
	@PostConstruct
	public void init(){
		Room r1 = new Room();
		r1.setName("いっかい");
		roomRepository.saveAndFlush(r1);
		Room r2 = new Room();
		r2.setName("にかい");
		roomRepository.saveAndFlush(r2);
		
		MyData d1 = new MyData();
		d1.setName("tuyano");
		d1.setAge(123);
		d1.setMail("syoda@tuyano.com");
		d1.setMemo("090999999");
		d1.setRoom(r1);
		repository.saveAndFlush(d1);
		MyData d2 = new MyData();
		d2.setName("hanako");
		d2.setAge(15);
		d2.setMail("hanako@flower");
		d2.setMemo("080888888");
		d2.setRoom(r1);
		repository.saveAndFlush(d2);
		MyData d3 = new MyData();
		d3.setName("sachiko");
		d3.setAge(37);
		d3.setMail("sachico@happy");
		d3.setMemo("070777777");
		d3.setRoom(r2);
		repository.saveAndFlush(d3);
	}


}
