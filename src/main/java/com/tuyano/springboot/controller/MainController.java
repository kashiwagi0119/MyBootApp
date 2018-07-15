package com.tuyano.springboot.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuyano.springboot.entity.Item;
import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.entity.Room;
import com.tuyano.springboot.repositories.ItemRepository;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.RoomRepository;

@Controller
public class MainController {
	  
	@Autowired
	MyDataRepository repository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ItemRepository itemRepository;
	
	// メインメニューの初期表示
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	// テスト用
	@RequestMapping(value = "/TestWindow")
	public String test() {
		return "test";
	}
	
//	// 初期処理のDB登録
//	@PostConstruct
//	public void init(){
//		
//		Item i1 = new Item();
//		i1.setItemName("アイテム1");
//		itemRepository.saveAndFlush(i1);
//		Item i2 = new Item();
//		i2.setItemName("アイテム2");
//		itemRepository.saveAndFlush(i2);
//		
//		
//		Room r1 = new Room();
//		r1.setName("いっかい");
//		r1.setItem(i1);
//		roomRepository.saveAndFlush(r1);
//		Room r2 = new Room();
//		r2.setName("にかい");
//		r2.setItem(i2);
//		roomRepository.saveAndFlush(r2);
//		
//		MyData d1 = new MyData();
//		d1.setName("tuyano");
//		d1.setAge(123);
//		d1.setMail("syoda@tuyano.com");
//		d1.setMemo("090999999");
//		d1.setRoom(r1);
//		repository.saveAndFlush(d1);
//		MyData d2 = new MyData();
//		d2.setName("hanako");
//		d2.setAge(15);
//		d2.setMail("hanako@flower");
//		d2.setMemo("080888888");
//		d2.setRoom(null);
////		d2.setRoom(r1);
//		repository.saveAndFlush(d2);
//		MyData d3 = new MyData();
//		d3.setName("aiueo");
//		d3.setAge(37);
//		d3.setMail("aiueo@happy");
//		d3.setMemo("070777777");
//		d3.setRoom(r2);
//		repository.saveAndFlush(d3);
//		
//		for (int i = 0; i < 30; i++) {
//			MyData d9 = new MyData();
//			d9.setName("takayuki");
//			d9.setAge(37);
//			d9.setMail("takayuki@happy");
//			d9.setMemo("070777777");
//			d9.setRoom(r2);
//			repository.saveAndFlush(d9);
//		}
//	}


}
