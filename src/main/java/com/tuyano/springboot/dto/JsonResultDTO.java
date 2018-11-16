package com.tuyano.springboot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class JsonResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> messageList = new ArrayList<String>();
	private List<String> errorList = new ArrayList<String>();
	private Object dataList;

    public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public Object getDataList() {
		return dataList;
	}

	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}

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
