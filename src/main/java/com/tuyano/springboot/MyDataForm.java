package com.tuyano.springboot;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import lombok.Data;

@Data
@SessionScope
@Component
public class MyDataForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public MyDataForm() {
		super();
		room = new Room();
	}
	
	private String name;

	private String mail;

	private String memo;

	private Room room;
	
    /**
     * 年齢From
    */
    private Integer ageFrom;
    
    /**
     * 年齢To
    */
    private Integer ageTo;
    
    /**
     * チェック1
    */
    private boolean check1;
    
    /**
     * チェック2
    */
    private String[] check2;
    
    /**
     * ラジオ1
    */
    private String radio1;
    
    /**
     * セレクト1
    */
    private String select1;
    
    /**
     * セレクト2
    */
    private String[] select2;
    
    /**
     * 日付1
    */
    private String date1;
    
}
