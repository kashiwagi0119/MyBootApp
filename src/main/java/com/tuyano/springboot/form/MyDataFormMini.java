package com.tuyano.springboot.form;

import java.io.Serializable;
import org.springframework.stereotype.Component;

import com.tuyano.springboot.entity.Item;
import com.tuyano.springboot.entity.Room;

import lombok.Data;

@Data
@Component
public class MyDataFormMini implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String mail;
	private String memo;
	private String room;
	private String item;
}
