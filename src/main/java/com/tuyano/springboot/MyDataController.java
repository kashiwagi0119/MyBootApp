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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.constant.SelectEnum;
import com.tuyano.springboot.repositories.ItemRepository;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;

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
	
	// 検索画面の初期表示
	@RequestMapping(value = "/MyData/list")
	public String index(Model model) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		
		Iterable<MyData> list = repository.findAll();
		model.addAttribute("datalist", list);
		
		model.addAttribute("myDataForm", new MyDataForm());
		return "index";
	}
	
	// Criteriaで検索
	@RequestMapping(value = "/MyData/search")
	public String searchCriteria(Model model, MyDataForm form) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		
		List<MyData> list = service.findCriteria(form);
		model.addAttribute("datalist", list);
		return "index";
	}

	// repositoryで検索
	@RequestMapping(value = "/MyData/searchRepository")
	public String searchRepository(Model model, MyDataForm form) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		// 単純な検索ならServiceを経由しなくもいいかな
		List<MyData> list = repository.findByNameOrderByIdDesc(form.getName());
		model.addAttribute("datalist", list);
		return "index";
	}
	
	// Specificationで検索
	@RequestMapping(value = "/MyData/searchSpecification")
	public String searchSpecification(Model model, MyDataForm form) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		
		List<MyData> list = service.findSpecification(form);
		model.addAttribute("datalist", list);
		return "index";
	}
	
	// JPQLで検索
	@RequestMapping(value = "/MyData/searchJPQL")
	public String searchJPQL(Model model, MyDataForm form) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		
		List<MyData> list = service.findJPQL(form);
		model.addAttribute("datalist", list);
		return "index";
	}
	
	// SQLで検索
	@RequestMapping(value = "/MyData/searchSQL")
	public String searchSQL(Model model, MyDataForm form) {
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("checkItems", CHECK_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		model.addAttribute("selectEnums", SelectEnum.values());
		
		List<MyData> list = service.findSQL(form);
		model.addAttribute("datalist", list);
		return "index";
	}
	
	
	
	// 新規登録画面へ
	@RequestMapping(value = "/MyData/insertwindow")
	public String insertwinddow(Model model, MyDataForm form) {
		// セレクトボックス設定
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		model.addAttribute("mydata", new MyData());
		return "insert";
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
		// セレクトボックス設定
		model.addAttribute("selectRooms", roomRepository.findAll());
		model.addAttribute("selectItems", itemRepository.findAll());
		return "update";
	}
	
	// 新規登録画面の登録ボタン
	@RequestMapping(value = "/MyData/insert")
	public String insert(Model model, MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/MyData/search";
	}
	
	 // 更新画面の更新ボタン
	@RequestMapping(value = "/MyData/update")
	public String update(MyData mydata) {
		repository.saveAndFlush(mydata);
		return "redirect:/MyData/search";
	}
	
	// 新規登録画面・更新画面の戻るボタン
	@RequestMapping(value = "/MyData/back")
	public String back(Model model) {
		return "redirect:/MyData/search";
	}
	
	// 初期処理のDB登録
	@PostConstruct
	public void init(){
		
		Item i1 = new Item();
		i1.setItemname("アイテム1");
		itemRepository.saveAndFlush(i1);
		Item i2 = new Item();
		i2.setItemname("アイテム2");
		itemRepository.saveAndFlush(i2);
		
		
		Room r1 = new Room();
		r1.setName("いっかい");
		r1.setItem(i1);
		roomRepository.saveAndFlush(r1);
		Room r2 = new Room();
		r2.setName("にかい");
		r2.setItem(i2);
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
