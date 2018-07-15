package com.tuyano.springboot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class JsonResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> messageList = new ArrayList<String>();
	private List<String> errorList = new ArrayList<String>();
	private Object dataList;
	
    /**
     * メッセージリストに追加する。
     * @param message メッセージ
     */
    public void addMessage(String message) {
        this.messageList.add(message);
    }
    
    /**
     * エラーメッセージリストに追加する。
     * @param message エラーメッセージ
     */
    public void addError(String message) {
    	this.errorList.add(message);
    }


}
