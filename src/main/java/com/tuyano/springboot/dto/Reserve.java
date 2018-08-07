package com.tuyano.springboot.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Reserve implements Serializable {

	private static final long serialVersionUID = 1L;
	
    /**
     * reserveNo
    */
    private String reserveNo;
    
    /**
     * reserveNoを返す。
     * @return reserveNo
     */
    public String getReserveNo() {
        return reserveNo;
    }
    
    /**
     * reserveNoを設定する。
     * @param reserveNo reserveNo
     */
    public void setReserveNo(String reserveNo) {
        this.reserveNo = reserveNo;
    }
    
    /**
     * オブジェクトの文字列表現を返す。
     * @return オブジェクトの文字列表現
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" , ");
        sb.append("[reserveNo=").append(getReserveNo()).append("]");
        return sb.toString();
    }



}
