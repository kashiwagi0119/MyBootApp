package com.tuyano.springboot.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.dto.Message;
import com.tuyano.springboot.view.MessagesXlsxView;

@Controller
public class ExcelController {

    @Autowired
    ResourceLoader resourceLoader;

	@RequestMapping(value = "/excel")
	public String index() {
		return "/excel";
	}

	// Excelダウンロード新規
    @RequestMapping("/ExcelDownloadSinki")
    public ModelAndView excelDownloadSinki() {
    	List<Message> messages = new ArrayList<Message>();
    	for (int i = 0; i < 3; i++) {
    		Message msg = new Message();
    		msg.setId(String.valueOf(i));
    		msg.setName("name");
    		msg.setText("text");
		}
        return new ModelAndView(new MessagesXlsxView(), "messages", messages);
    }

    /**
     * テンプレートのダウンロード
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/ExcelDownloadTemplate")
    public ResponseEntity<Resource> c002FileDownload() throws UnsupportedEncodingException {
    	String filepath = "static/excelTemplate/C002.xlsx";
    	Resource resource = resourceLoader.getResource("classpath:" + filepath);
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Content-Type", "application/octet-stream");
    	headers.add("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode("テンプレートEXCELファイル名.xlsx", StandardCharsets.UTF_8.name()));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(resource, headers, status);
    }




}
