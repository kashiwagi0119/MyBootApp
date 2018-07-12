package com.tuyano.springboot.form;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component
public class FileUploadForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private MultipartFile uploadedFile;

}
