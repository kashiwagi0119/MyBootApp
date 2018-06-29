package com.tuyano.springboot;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
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

	private Item item;
	
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
     * チェック3
     */
    private String[] check3;
    
    /**
     * ラジオ1
    */
    private String radio1;
    
    /**
     * ラジオ2
     */
    private String radio2;
    
    /**
     * セレクト1
    */
    private String select1;
    
    /**
     * セレクト2
    */
    private String[] select2;
    
    private String select3;
    
    /**
     * 日付1
    */
    private String date1;
    
    String[] favariteMovies;
    
	private String name2;
}
