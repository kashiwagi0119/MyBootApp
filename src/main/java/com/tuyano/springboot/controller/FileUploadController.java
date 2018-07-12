package com.tuyano.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuyano.springboot.form.FileUploadForm;

@Controller
public class FileUploadController {
	  
	@RequestMapping(value = "/FileUploadWindow")
	public String fileUploadWindow(Model model, FileUploadForm fileUploadForm) {
		return "fileUpload/fileUpload";
	}
	
	@RequestMapping(value = "/FileUploadSubmit")
	public String fileUpload(Model model, FileUploadForm fileUploadForm) {
		return "fileUpload/fileUpload";
	}
	
	// Criteriaで検索
	@RequestMapping(value = "/FileUploadAjax")
	@ResponseBody
	public List<String> fileUploadAjax(Model model, FileUploadForm fileUploadForm) {
		System.out.println(fileUploadForm.getUploadedFile().getOriginalFilename());
		System.out.println(fileUploadForm.getName());
		return Arrays.asList("●","●");

	}

}
