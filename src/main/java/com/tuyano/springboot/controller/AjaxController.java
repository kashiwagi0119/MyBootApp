package com.tuyano.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.form.MyDataForm;
import com.tuyano.springboot.service.MyDataService;

@Controller
public class AjaxController {
	  
	@Autowired
	private MyDataService service;
	
	// メインメニューの初期表示
	@RequestMapping(value = "/Ajax/AjaxList")
	public String index() {
		return "/ajax/ajaxList";
	}

	// Criteriaで検索
	@RequestMapping(value = "/Ajax/search")
	@ResponseBody
	public List<MyData> searchCriteria(Model model, MyDataForm form) {
		
		List<MyData> list = service.findCriteria(form);
		
		return list;
	}
	
}
