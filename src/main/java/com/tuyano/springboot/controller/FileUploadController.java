package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuyano.springboot.form.FileUploadForm;

@Controller
public class FileUploadController {
	  
	@RequestMapping(value = "/FileUploadWindow")
	public String fileUploadWindow(Model model, FileUploadForm fileUploadForm) {
		return "fileUpload/fileUpload";
	}
	
	@RequestMapping(value = "/FileUpload")
	public String fileUpload(Model model, FileUploadForm fileUploadForm) {
		System.out.println(fileUploadForm.getUploadedFile().getOriginalFilename());
		System.out.println(fileUploadForm.getUploadedFile().getSize());
		return "fileUpload/fileUpload";
	}

}
