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
	@Autowired
	HttpSession session;
	@Autowired
	MyDataForm myDataFormSession;
	
    @ModelAttribute("myDataForm")
    public MyDataForm setMyDataForm() {
        return myDataFormSession;
    }
    
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
	public String index(Model model, MyDataForm myDataForm) {
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		Iterable<MyData> list = repository.findAll();
		model.addAttribute("datalist", list);
		
		model.addAttribute("myDataForm", new MyDataForm());
		return "index";
	}

	// repositoryで検索
	@RequestMapping(value = "/search")
	public String search(Model model, MyDataForm form) {
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		
		List<MyData> list = service.findRepository(form);
		model.addAttribute("datalist", list);
		return "index";
	}
	
	// Criteriaで検索
	@RequestMapping(value = "/searchCriteria")
	public String searchCriteria(Model model, MyDataForm form) {
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		
		List<MyData> list = service.findCriteria(form.getName());
		model.addAttribute("datalist", list);
		return "index";
	}
	
	@RequestMapping(value = "/insertwindow")
	public String insertwinddow(Model model, MyDataForm form) {
		// セレクトボックス設定
		model.addAttribute("selectItems", roomRepository.findAll());
		model.addAttribute("mydata", new MyData());
		return "insert";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, MyDataForm form, @PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/search";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String update(Model model, MyDataForm form, @PathVariable Long id) {
		Optional<MyData> data = repository.findById(id);
		model.addAttribute("mydata",data.get());
		// セレクトボックス設定
		model.addAttribute("selectItems", roomRepository.findAll());
		return "update";
	}
    
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("mydata") MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/search";
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
		d2.setRoom(null);
//		d2.setRoom(r1);
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
