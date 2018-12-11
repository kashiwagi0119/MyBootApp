package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuyano.springboot.dto.JsonResultDTO;


@Controller
public class GamenlockController {

	@RequestMapping(value = "/gamenlock")
	public String index(Model model) {

    	model.addAttribute("msg0", "aaaaa");
    	model.addAttribute("msg2", "bbbbb");

		return "/gamenlock";
	}

	@RequestMapping(value = "/gamenlocksleep")
	@ResponseBody
	public JsonResultDTO gamenlocksleep(Model model) {

		JsonResultDTO jsonResult = new JsonResultDTO();

	     try{
	         Thread.sleep(1000);
	     }catch(InterruptedException e){}

		return jsonResult;
	}




}
