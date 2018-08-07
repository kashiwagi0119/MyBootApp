package com.tuyano.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.dto.Message;
import com.tuyano.springboot.view.MessagesXlsxView;

@Controller
public class ExcelController {
	  
	@RequestMapping(value = "/excel")
	public String index() {
		return "/excel";
	}

    @RequestMapping("/ExcelDownload")
    public ModelAndView messagesXlsx() {
    	List<Message> messages = new ArrayList<Message>();
    	for (int i = 0; i < 3; i++) {
    		Message msg = new Message();
    		msg.setId(String.valueOf(i));
    		msg.setName("name");
    		msg.setText("text");
		}
        return new ModelAndView(new MessagesXlsxView(), "messages", messages);
    }
    
    
}
